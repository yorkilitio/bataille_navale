package players;

import java.util.*;
import view.*;
import model.*;
import game.*;


//player class allowing the user to choose moves
public class Player implements PlayerConsole{
    private String name;
    Champ playerChamp;

    public Player(String name){
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
        this.playerChamp.placer(boat, lig, col, direction);
    }

    public void viser(int lig, int col, Obus obus){
        this.playerChamp.viserObus(lig, col, obus);
    }

    public void viserOpp(int lig, int col, Obus obus, Champ ch){
        ch.viserObus(lig, col, obus);
    }

}