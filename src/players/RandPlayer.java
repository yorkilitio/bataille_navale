package players;

import java.util.*;
import view.*;
import model.*;
import game.*;

//player class choosing random moves
public class RandPlayer implements PlayerConsole{
    private String name;
    Champ playerChamp;

    public RandPlayer(String name){
        this.name = name;
        this.playerChamp = playerChamp;
    }

    public void setChamp(Champ ch){
		this.playerChamp = ch;
	}

    public String toString(){
        return this.name;
    }

    public Champ returnChamp(){
        return this.playerChamp;
    }    

    public void placerBateau(Bateau boat, int lig, int col, boolean direction){
        lig = new Random().nextInt(10);
        col = new Random().nextInt(10);
        int directionNum = new Random().nextInt(2);
        if(directionNum == 0){
            direction = true;
        }
        else{
            direction = false;
        }
        this.playerChamp.placer(boat, lig, col, direction);
    }

    public void viser(int lig, int col, Obus obus){
        lig = new Random().nextInt(10);
        col = new Random().nextInt(10);        
        this.playerChamp.viserObus(lig, col, obus);
    }

    public void viserOpp(int lig, int col, Obus obus, Champ ch){
        lig = new Random().nextInt(10);
        col = new Random().nextInt(10);
        ch.viserObus(lig, col, obus);
    }    

}