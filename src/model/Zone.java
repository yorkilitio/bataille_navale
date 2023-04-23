package model;
import java.util.*;
import java.io.*;
import view.*;
import game.*;
import players.*;

public class Zone{
    private Bateau bateau;
    private Obus obus;
    public boolean maskState = false;


    private int lig,col;
    private Champ champ;

    public Zone(int lig, int col){
        this.lig = lig;
        this.col = col;
        this.bateau = null;
        this.obus = null;

        
    }
    public int getLig() {
        return lig;
    }

    public int getCol() {
        return col;
    }

    public Bateau getBoat(){
        return this.bateau;
    }

    public Obus getObus(){
        return this.obus;
    }

    //representation of Zone
    public String toString(){
        String res = " ";
        if(this.bateau == null && this.obus == null){
            res += " "+"_";
        }
        else if(this.bateau != null && this.obus == null){
            if(maskState == true){               
                res += " "+"_";
            }
            else{
                res += " "+"B";               
            }            
        }
        else if(this.bateau == null && this.obus != null){
            res += " "+"!";
        }
        else if(this.bateau != null && this.obus != null){
            res += " "+"X";

        }
        else{
            res += " "+"B";
        }

                
        return res;
    }

    //method to add a boat on a Zone
    public void addBateau(Bateau boat, boolean direction){
        this.bateau = boat;
    }

    public void removeBateau(Bateau boat, boolean direction){
        this.bateau = null;
    }

    //method to target a boat on a Zone
    public void viser1(Obus obus){
        this.obus = obus;
    }

    public void mask(boolean state){
        if(state){
            this.maskState = true;
        }
        else{
            this.maskState = false;
        }
    }




    
}