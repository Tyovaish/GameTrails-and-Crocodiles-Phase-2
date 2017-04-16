package View;

import Model.Map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Lazaro on 4/11/2017.
 */
public class paintHex {

    final int radius = 110; //radius
    final int width = radius * 2;
    final int height = (int) (Math.sqrt(3)/2 * width);



    public Polygon setHex(int row, int col) {
        int[] cx, cy;
        int x = row;
        int y = col;


        cx = new int[]{(int) (x + radius * Math.cos(2 * Math.PI * 1 / 6)), (int) (x + radius * Math.cos(2 * Math.PI * 2 / 6)),
                (int) (x + radius * Math.cos(2 * Math.PI * 3 / 6)), (int) (x + radius * Math.cos(2 * Math.PI * 4 / 6)),
                (int) (x + radius * Math.cos(2 * Math.PI * 5 / 6)), (int) (x + radius * Math.cos(2 * Math.PI))};

        cy = new int[]{(int) (y + radius * Math.sin(2 * Math.PI * 1 / 6)), (int) (y + radius * Math.sin(2 * Math.PI * 2 / 6)),
                (int) (y + radius * Math.sin(2 * Math.PI * 3 / 6)), (int) (y + radius * Math.sin(2 * Math.PI * 4 / 6)),
                (int) (y + radius * Math.sin(2 * Math.PI * 5 / 6)), (int) (y + radius * Math.sin(2 * Math.PI))};
        //CREATES THE HEX IN TWO HALVES WITH EQUAL SIDES
        return new Polygon(cx, cy, 6);
    }

    public void drawCursor(int i, int j, Graphics2D g2){

        int vert;
        int horiz = radius +(int)(j*((width/4*2.89)));
        if(j % 2 == 0)
            vert = radius +(i * height);
        else
            vert = 10 + ((i+1) * (height));


        Polygon poly = setHex(horiz, vert);
        g2.setClip(poly);
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(9));
        g2.drawPolygon(poly);
    }


    public void fillHex(int i, int j, Map board, Graphics2D g2) {

        String riverType;
        int rivers = board.getTileAt(i,j).getRiverEdges().size();
        String type = board.getTileAt(i,j).getFeature().getType();
        int rot = board.getTileAt(i,j).getOrientation().getNumberOfRotations();
        riverType = getRiverType(rivers);
        File img = new File("./src/View/Images/" + type + ".jpg");
        File img2 = new File("./src/View/Images/" + riverType);

        BufferedImage bi = null;
        BufferedImage bi2 = null;
        BufferedImage transparentImage = null;

        int vert;
        int horiz = radius +(int)(j*((width/4*2.89)));
        if(j % 2 == 0)
            vert = radius +(i * height);
        else
            vert = 10 + ((i+1) * (height));


        if(type == null) {return;}
        else{
            try {
                bi = ImageIO.read(img);
            } catch (IOException e) {
                System.err.println("Could not load image file!");
            }
        }
        if(riverType != null){
            try {
                bi2 = ImageIO.read(img2);

            } catch (IOException e) {
                System.err.println("Could not load image file!");
            }

            Image imageWithTransparency = makeColorTransparent(bi2);
            transparentImage = imageToBufferedImage(imageWithTransparency);
        }

        g2.setPaintMode();
        if(rot > -1) {
            Polygon poly = setHex(horiz, vert);
            g2.rotate(Math.toRadians(rot * 60), horiz, vert);
            g2.setClip(poly);
            if(bi != null)
                g2.drawImage(bi.getScaledInstance(230, 320, 0), horiz - radius, vert - 150, null);
            if(riverType != null && riverType.equals("source.PNG"))
                g2.drawImage(transparentImage, horiz - 55, vert-100, null);
            else if(riverType != null && riverType.equals("sharpbend.PNG"))
                g2.drawImage(transparentImage, horiz-77, vert-190, null);
            else if(riverType != null && riverType.equals("Y.PNG"))
                g2.drawImage(transparentImage, horiz-120, vert-110, null);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(15));
            g2.draw(poly);

        }





    }

    private String getRiverType(int river){
        switch (river){
            case 0: {
                return null;
            }
            case 1:{
                return "source.PNG";

            }
            case 2:{
                return "sharpbend.PNG";

            }
            case 3:{
                return "Y.PNG";

            }
        }
        return null;
    }


    public  Point pxtoHex(int mx, int my) {
        Point p = new Point(-1,-1);
        int  t = (int) (radius / 1.73205);//(2 sqrt(3)) = r / sqrt(3)
        int x;
        int y =  (mx / (t + radius))  ; //this gives a quick value for y. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
        //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column
        if(y%2 == 0) {
            x = (my  / height);
        }
        else
            x = (my - radius)/height;

        p.x=x;
        p.y=y;

        return p;
    }

    private static BufferedImage imageToBufferedImage(final Image image)
    {
        final BufferedImage bufferedImage =
                new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    public static Image makeColorTransparent(final BufferedImage im)
    {
        final ImageFilter filter = new RGBImageFilter()
        {
            // the color we are looking for (white)... Alpha bits are set to opaque
            public int markerRGB =  0xFFFFFFFF;

            public final int filterRGB(final int x, final int y, final int rgb)
            {
                if ((rgb | 0xFF000000) == markerRGB)
                {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                }
                else
                {
                    // nothing to do
                    return rgb;
                }
            }
        };

        final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }



}
