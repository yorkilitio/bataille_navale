package game;

import java.util.*;
import view.*;
import model.*;
import players.*;


public class Game{
    private PlayerConsole player1;
    private PlayerConsole player2;
    private boolean isModel;
    private GridPanel p1Panel;
    private GridPanel p2Panel;
    private Champ p2champ;
    private Champ p1champ;
    private int boatNumber1 = 5;
    private int boatNumber2 = 5;
    private int timer = 0;
    private int chrono = 0;
    private Scanner scanner = new Scanner(System.in);

    public Game(PlayerConsole player1, PlayerConsole player2, boolean isModel){
        this.player1 = player1;
        this.player2 = player2;
        this.isModel = isModel;                
    }

    public String toString(){
        String mode = " ";

        if(isModel == true){
            mode = "Vous voulez jouer avec le terminal";
        }
        else{
            mode = "Vous voulez jouer avec l'interface graphique";
        }

        return "\njouer 1: "+this.player1+"\njouer 2: "+this.player2+"\n"+mode;
    }

    //method to play the game
    public void play(){
        p1champ = new Champ(this.player1);
        p2champ = new Champ(this.player2);
        boolean direction = false;
        if(isModel == true){
            //System.out.println(this.p1champ);
            //System.out.println(this.p2champ);
            while(boatNumber2 >= 2){
                this.player2.placerBateau(new Bateau(boatNumber2), 10, 10, true);
                if(p2champ.isOutOfBounds() == false){
                    boatNumber2 --;
                }                
            }


             
            System.out.println(player1+" vous devez placer 4 navires de taille 5 jusq'ua 2");
            while(boatNumber1 >= 2){
                System.out.println("saisir une ligne: " );
                int row = Integer.parseInt(scanner.next());
                System.out.println("saisir une une colonne: " );
                int column = Integer.parseInt(scanner.next());
                System.out.println("saisir 1 pour un navire horizontal ou 2 pour un naivre vertical: " );
                int position = Integer.parseInt(scanner.next());
                if(position == 1){
                    direction = false;
                }
                else if (position == 2 ){
                    direction = true;
                }
                else{
                    System.out.println("veuillez entrer 1 ou 2" );

                }
                this.player1.placerBateau(new Bateau(boatNumber1), row, column, direction);
                if(p1champ.isOutOfBounds() == false){
                    boatNumber1 --;
                }                
            }
            System.out.println(this.player1+":\n");
            System.out.println(this.p1champ);
            System.out.println(this.player2+":\n");
            this.p2champ.maskChamp(true);
            System.out.println(this.p2champ);

            System.out.println("les deux jouers ont placé leurs navires");
            System.out.println(player1+" vous devez viser le champ de "+player2);

            while(!this.p1champ.isEmpty() && !this.p2champ.isEmpty()){
                System.out.println("saisir une ligne: " );
                int row = Integer.parseInt(scanner.next());
                System.out.println("saisir une une colonne: " );
                int column = Integer.parseInt(scanner.next());
                this.player1.viserOpp(row, column,new Obus(), p2champ);
                this.player2.viserOpp(row, column,new Obus(), p1champ);
                System.out.println(this.player1+":\n");
                System.out.println(this.p1champ);
                System.out.println(this.player2+":\n");
                System.out.println(this.p2champ);                                
            }
            this.p2champ.maskChamp(false);
            System.out.println(this.player1+":\n");
            System.out.println(this.p1champ);
            System.out.println(this.player2+":\n");
            System.out.println(this.p2champ);
            System.out.println("Jeu terminé");              
            if(this.p1champ.isEmpty()){
                System.out.println(this.player2+" a gagné");
            }
            else{
                System.out.println(this.player1+" a gagné");
            }
                     

        }
        else{
            GridFrame window1 = new GridFrame(p1champ,p2champ);
            VueConsole console = new VueConsole(p1champ);
            window1.displayFrame();
            p1Panel = window1.returnPanel1();
            p2Panel = window1.returnPanel2();
            this.p2champ.maskChamp(true);
            
            while(boatNumber2 >= 2){
                this.player2.placerBateau(new Bateau(boatNumber2), 10, 10, true);
                if(p2champ.isOutOfBounds() == false){
                    boatNumber2 --;
                }                
            }
            System.out.println(this.player2+" a placé ses navires, placez vos navires");
            System.out.println(player1+" vous devez placer 4 navires de taille 5 jusq'ua 2");
            System.out.println("clic droit pour placer votre navire horizontalement et clic gauche pour le placer verticalement");
            p1Panel.refresh();
            while((p1Panel.returnUpdate() != 4) && (p1champ.boatSize()!= 4)){
                System.out.println();
            }

            p1Panel.refresh();
            System.out.println("C'est parti! \n"+player1+" vous devez viser le champ de "+player2);
            p1Panel.refresh();


            do{
                if(p1Panel.newUpdate()){                    
                    this.player2.viserOpp(10,10,new Obus(), p1champ);
                    p1Panel.refresh();            
                }
                else{

                }  
            }while(!this.p1champ.isEmpty() && !this.p2champ.isEmpty());


            System.out.println("Jeu terminé");
            if(this.p1champ.isEmpty()){
                System.out.println(this.player2+" a gagné");
            }
            else{
                System.out.println(this.player1+" a gagné");
            }
            this.p2champ.maskChamp(false);                       
            

        }


    }



}