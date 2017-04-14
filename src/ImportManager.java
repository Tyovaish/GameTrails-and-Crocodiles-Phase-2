import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Lazaro on 4/12/2017.
 */
public class ImportManager {

    public ImportManager() {
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
                    System.out.println(currentLine);
                    getCoordinates(currentLine);
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

    private int getOrientation(int[] riverEdges){
        int rotation = 0;
        switch (riverEdges.length){
            case 1:{
                rotation = riverEdges[0] -1;
                break;
            }
            case 2:{
                if(riverEdges[0] == 1 && riverEdges[1]==3)
                    rotation = 0;
                else if(riverEdges[0] == 2 && riverEdges[1]==4)
                    rotation = 1;
                else if(riverEdges[0] == 3 && riverEdges[1]==5)
                    rotation = 2;
                else if(riverEdges[0] == 4 && riverEdges[1]==6)
                    rotation = 3;
                else if(riverEdges[0] == 5 && riverEdges[1]==1)
                    rotation = 4;
                else if(riverEdges[0] == 6 && riverEdges[1]==2)
                    rotation = 5;
                break;
            }
            case 3:{
                if(riverEdges[0] == 6 && riverEdges[1]==2 && riverEdges[2]==4)
                    rotation = 0;
                else if(riverEdges[0] == 1 && riverEdges[1]==3 && riverEdges[2]==5)
                    rotation = 1;
                else if(riverEdges[0] == 2 && riverEdges[1]==4 && riverEdges[2]==6)
                    rotation = 2;
                else if(riverEdges[0] == 3 && riverEdges[1]==5 && riverEdges[2]==1)
                    rotation = 3;
                else if(riverEdges[0] == 4 && riverEdges[1]==6 && riverEdges[2]==2)
                    rotation = 4;
                else if(riverEdges[0] == 5 && riverEdges[1]==1 && riverEdges[2]==3)
                    rotation = 5;
                break;
            }
        }
        return rotation;
    }

    private void getCoordinates(String text){

        int row;
        int col;
        String substr;

        substr = text.substring(8, text.indexOf(" "));
        row = Integer.parseInt(substr);
        substr = text.substring(text.indexOf(" ") + 1);
        substr = substr.substring(0 , substr.indexOf(")"));
        col = Integer.parseInt(substr);

        System.out.println(row + " " + col );
        getType(text);

    }

    private void getType(String text){
        String substr;
        substr = text.substring(text.indexOf(" ") + 4);
        substr = substr.substring(0 , substr.indexOf(" "));
        System.out.println(substr);
        getriverEdges(text);
    }

    private void getriverEdges(String text){
        String substr;
        String temp;
        int face1, face2 = 0, face3 = 0;
        int index = 0;
        substr = text.substring(text.indexOf(")") + text.indexOf(" "));
        int length = substr.length();

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

            int [] riverEdges = new int[index];
            switch(index){
                case 1:{
                    riverEdges[0] = face1;
                    System.out.println(getOrientation(riverEdges));
                    break;
                }
                case 2:{
                    riverEdges[0] = face1;
                    riverEdges[1] = face2;
                    System.out.println(getOrientation(riverEdges));
                    break;
                }
                case 3:{
                    riverEdges[0] = face1;
                    riverEdges[1] = face2;
                    riverEdges[2] = face3;
                    System.out.println(getOrientation(riverEdges));
                    break;
                }
            }

        }
        else{
            int [] riverEdges = new int[1];
            riverEdges[index] = 1;
            System.out.println(getOrientation(riverEdges));
        }




    }

}

