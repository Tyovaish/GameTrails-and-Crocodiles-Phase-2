package Model.Wonder;

import java.lang.reflect.Array;

/**
 * Created by larry on 4/16/2017.
 */
public class Wonder {
    private WonderRow[] rows;
    private int currentRow;

    private static WonderRow[] initializeWonder(){//create Wonder
        WonderRow[] Wonder = new WonderRow[15];
        for(int i = 0; i < 3; i++){ //set first 3 rows
            Wonder[i] = new WonderRow();
            Wonder[i].size = 4;
        }
        for(int i = 3; i < 7; i++ ){//set next 4
            Wonder[i] = new WonderRow();
            Wonder[i].size = 5;
        }
        for(int i = 7; i < 12; i++ ){ //set next 5
            Wonder[i] = new WonderRow();
            Wonder[i].size = 6;
        }
        for(int i = 12; i < 15; i++ ){//set last 3
            Wonder[i] = new WonderRow();
            Wonder[i].size = 7;
        }
        return Wonder;
    }

    private Boolean checkWonderVictory(int players, WonderRow[] rows, int currentRow ){
        if(currentRow < 12){
            return false;
        }
        else if(players == 2 && currentRow == 11 ){
            return true;
        }
        else if(players == 3 && currentRow == 12 ){
            return true;
        }
        else
            return false;
    }

    public int getCurrentRow(){return this.currentRow;}
//to do: add playermark, and irrigation mark initilization
    //check for playermark equal to number of players
    //check for irrigation mark to change desert tiles to pastures
    //add buyBrick that deals with brickbuying rules
    //
}
