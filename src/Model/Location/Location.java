package Model;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Location {
    int xPosition;
    int yPosition;
    boolean equals(Location location2){
        return location2.getX()==this.getX() && location2.getY()==this.getY();
    }
    boolean equals(int x,int y){
        return xPosition==x && yPosition==y;
    }
    int getX(){
        return xPosition;
    }
    int getY(){
        return yPosition;
    }
}
