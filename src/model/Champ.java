package model;
import java.util.*;
import java.io.*;
import view.*;
import game.*;
import players.*;

public class Champ extends AbstractListenableModel {
    private Zone tab[][];
    private PlayerConsole player;
    private ArrayList<Bateau> list = new ArrayList<Bateau>();
    static boolean isOutofbounds = false;

    public Champ(PlayerConsole player){
        this.player = player;        
        tab = new Zone[10][10];
        for(int lig = 0; lig < 10; lig++){
            for(int col = 0; col < 10; col++){
                tab[lig][col]= new Zone(lig,col);
            }

        }
        this.player.setChamp(this);
    }


    public String toString(){
        String res = "";
        for(int lig = 0; lig < 10; lig++){
            for(int col = 0; col < 10; col ++){
                res+=" "+tab[lig][col];
            }
                res = res + "\n";
        }
        return res;

    }

    
    public Zone[][] getTab() {
        return tab;
    }

    //method to return list of boats placed on a Champ
    public ArrayList<Bateau> boatList(){
        return this.list;
    }

    public int boatSize(){
        return this.list.size();
    }

    public void maskChamp(boolean val){
        for(int lig = 0; lig < 10; lig++){
            for(int col = 0; col < 10; col ++){
                this.tab[lig][col].mask(val);
            }
        }        
    }    

    //method to place a boat on a Champ
    public void placer(Bateau boat, int lig, int col, boolean direction){
        int boatSize = boat.returnSize();
        list.add(boat);
        if(direction == true){
            for(int x = 0; x < boatSize; x++){
                try{
                    tab[lig + x][col].addBateau(boat,direction);
                    isOutofbounds = false;
                    
                }
                catch(Exception e){
                    isOutofbounds = true;
                    list.remove(boat);
                    for(int y = 0; y < boatSize; y++){
                        try{
                            tab[lig + y][col].removeBateau(boat,direction);

                        }
                        catch(Exception e1){

                        }
                    }
                }
            }
            

        }
        else{
            for(int x = 0; x < boatSize; x++){
                try{
                    tab[lig][col + x].addBateau(boat,direction);
                    isOutofbounds = false;
                
                }
                catch(Exception e){
                    isOutofbounds = true;
                    list.remove(boat);
                    for(int y = 0; y < boatSize; y++){
                        try{
                            tab[lig][col + y].removeBateau(boat,direction);

                        }
                        catch(Exception e1){

                        }

                    }                    
                }

            }
            this.fireChange();
        }
    }


    //method to target a Zone on a Champ
    public void viserObus(int lig, int col, Obus obus){
       this.tab[lig][col].viser1(obus);
       this.fireChange(); 
    }

    public boolean isOutOfBounds(){
        return isOutofbounds;
    }

    //method to verify if a Zone has no untouched boats
    public boolean isEmpty(){
        boolean empty = true;
        int counter = 0;
        for(int lig = 0; lig < 10; lig++){
            for(int col = 0; col < 10; col ++){
                if((tab[lig][col].getBoat() != null && tab[lig][col].getObus() == null)){
                    counter ++;
                }
                else{                   
                }

            }
        }
                    
        return counter < 1;
    }


}
