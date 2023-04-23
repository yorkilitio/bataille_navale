package game;

import java.util.*;
import view.*;
import model.*;
import players.*;

public class Main{
    public static void main(String []args){
        Scanner scanner2 = new Scanner(System.in);
        //creating players and instances of the game        
        RandPlayer player2 = new RandPlayer("L'ordinateur");        
        String name;
        int mode;
        boolean mode1 = false;


        //playing the game
        System.out.println("Salut, quel est votre nom?");
        name = scanner2.next();
        System.out.println("Saisir 1 pour jouer avec le model ou 2 avec l'interface graphique");
        mode = Integer.parseInt(scanner2.next());
        if(mode == 1){
            mode1 = true;
        }
        else{

        }
        Player player1 = new Player(name);
        Game game1 = new Game(player1, player2, mode1);        
        System.out.println(game1);
        game1.play();

    }
}