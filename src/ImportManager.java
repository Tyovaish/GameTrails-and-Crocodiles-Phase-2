import Model.Location.Location;
import Model.Map.Map;
import Model.Map.MapEditor;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Lazaro on 4/12/2017.
 */
public class ImportManager {

    private Map board;
    private MapEditor editor;
    private int rotation = 0;
    private int row;
    private int col;
    private String type;
    private ArrayList<Integer> riverEdges;

    public ImportManager(Map board) {
        this.board = board;
        editor = new MapEditor(this.board);
        File mapFile;
        String file = "src/newFile.txt";
        String currentLine;
        Boolean executable;
        Boolean correctFile;

        try
        {
            mapFile = new File(file);
            FileReader fileReader = new FileReader(mapFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            executable = mapFile.canExecute(); //if File is executable
            currentLine = bufferedReader.readLine();//read the first line
            correctFile = checkFileStart(currentLine);//check for "Start Map" else text file is wrong
            if(executable && correctFile) {
                currentLine = bufferedReader.readLine();
                while ( !checkFileEnd(currentLine)) {
                    setCoordinates(currentLine);
                    currentLine = bufferedReader.readLine();
                }
            }
            else
                System.out.println("An incorrect file has been selected.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private Boolean checkFileStart(String firstLine){
        return firstLine.equals("Begin Map");
    }

    private Boolean checkFileEnd(String lastLine){
        return lastLine.equals("End Map");
    }

    private void setOrientation(ArrayList<Integer> riverEdges){

        switch (riverEdges.size()){
            case 1:{
                rotation = riverEdges.get(0) -1;
                break;
            }
            case 2:{
                if(riverEdges.get(0) == 1 && riverEdges.get(1)==3)
                    rotation = 0;
                else if(riverEdges.get(0) == 2 && riverEdges.get(1)==4)
                    rotation = 1;
                else if(riverEdges.get(0) == 3 && riverEdges.get(1)==5)
                    rotation = 2;
                else if(riverEdges.get(0) == 4 && riverEdges.get(1)==6)
                    rotation = 3;
                else if(riverEdges.get(0) == 1 && riverEdges.get(1)==5)
                    rotation = 4;
                else if(riverEdges.get(0) == 2 && riverEdges.get(1)==6)
                    rotation = 5;
                break;
            }
            case 3:{
                if(riverEdges.get(0) == 6 && riverEdges.get(1)==2 && riverEdges.get(2)==4)
                    rotation = 0;
                else if(riverEdges.get(0) == 1 && riverEdges.get(1)==3 && riverEdges.get(2)==5)
                    rotation = 1;
                else if(riverEdges.get(0) == 2 && riverEdges.get(1)==4 && riverEdges.get(2)==6)
                    rotation = 2;
                else if(riverEdges.get(0) == 3 && riverEdges.get(1)==5 && riverEdges.get(2)==1)
                    rotation = 3;
                else if(riverEdges.get(0) == 4 && riverEdges.get(1)==6 && riverEdges.get(2)==2)
                    rotation = 4;
                else if(riverEdges.get(0) == 5 && riverEdges.get(1)==1 && riverEdges.get(2)==3)
                    rotation = 5;
                break;
            }
        }

    }

    private void setCoordinates(String text){
        String substr;

        substr = text.substring(8, text.indexOf(" "));
        row = Integer.parseInt(substr);
        substr = text.substring(text.indexOf(" ") + 1);
        substr = substr.substring(0 , substr.indexOf(")"));
        col = Integer.parseInt(substr);

        setType(text);

    }

    private void setType(String text){
        String temp;
        temp = text.substring(text.indexOf(" ") + 4);
        type = temp.substring(0 , temp.indexOf(" "));
        getriverEdges(temp);
    }

    private void getriverEdges(String text){
        String substr;
        String temp;
        int face1, face2 = 0, face3 = 0;
        int index = 0;
        substr = text.substring(text.indexOf("("));
        int length = substr.length();
        riverEdges = new ArrayList<Integer>();
        if(length != 2) {
            temp = substr.substring(1,2);
            face1 =  Integer.parseInt(temp); // first river face
            index++;
            if(length > 4) {
                temp = substr.substring(3, 4);
                face2 = Integer.parseInt(temp); // second river face
                index++;
            }
                    if(length > 6) {
                        temp = substr.substring(5, 6);
                        face3 = Integer.parseInt(temp); // third river face
                        index++;
                    }
            switch(index){
                case 1:{
                    riverEdges.add(face1);
                    setOrientation(riverEdges);
                    break;
                }
                case 2:{
                    riverEdges.add(face1);
                    riverEdges.add(face2);
                    setOrientation(riverEdges);
                    break;
                }
                case 3:{
                    riverEdges.add(face1);
                    riverEdges.add(face2);
                    riverEdges.add(face3);
                    setOrientation(riverEdges);
                    break;
                }
            }

        }
        else{
            rotation = 0;
        }


        //inserting tile to map
        Location loc = new Location(row, col);
        editor.insertTile(loc, createTile());



    }


    private Tile createTile(){
        return TileFactory.createTile(type, rotation, riverEdges);
    }
}

