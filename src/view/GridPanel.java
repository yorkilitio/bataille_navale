package view;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import model.*;
import game.*;
import players.*;



public class GridPanel extends JPanel implements ModelListener, MouseListener
{
    static int TAILLE = 40;
    static int boatNumber = 5;
    static int update = 0;
	private  Champ modele;
	private static Border border;
	private static Font labels = new Font("MV Boli", Font.PLAIN,20);
    private static Font gridLabels = new Font("MV Boli", Font.BOLD,12);
    static String[] numberLabel = {"1","2","3","4","5","6","7","8","9","10"};
    static String[] letterLabel = {"A","B","C","D","E","F","G","H","I","J"};

    public GridPanel(Champ grid){
		super();
		this.modele = grid;        		
		this.modele.addListener(this);
        addMouseListener(this);
        this.repaint();		
	}

	public void dessinerCol(Graphics g){
        for(int lig=1 ;lig<11;lig++ ) {
            g.setColor(Color.BLACK);
            g.drawString(GridPanel.numberLabel[lig - 1], 0, (lig * TAILLE));
        }
    }

	public void dessinerLig(Graphics g){
        for(int lig=1 ;lig<11;lig++ ) {
            g.setColor(Color.BLACK);
            g.drawString(GridPanel.letterLabel[lig - 1], (lig*TAILLE)+8,10);
        }
    }
    public void dessinerZone(Graphics g, Zone z){
        int lig = z.getLig()+1;
        int col = z.getCol()+1;
        g.drawString(z.toString(), (col*TAILLE), (lig * TAILLE));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(gridLabels);
        dessinerCol(g);
        dessinerLig(g);
        g.setFont(labels);
        for(int lig=0 ; lig <10 ;lig ++ ){
            for(int col=0; col<10;col++ ){
                dessinerZone(g,this.modele.getTab()[lig][col]);
            }
        }
    }

	@Override
	public void modelUpdated(Object source){
		System.out.println("modele change \n"+ this.modele.toString());
        update ++;
		this.repaint();
	}

    public boolean newUpdate(){
        return this.update > 0;
    }

    public void refresh(){
        this.update = 0;
    }

    public int returnUpdate(){
        return this.update; 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int lig = (e.getY()/TAILLE);
        int col = (e.getX()/TAILLE);
        if(SwingUtilities.isLeftMouseButton(e) && boatNumber >= 2){ 
            this.modele.placer(new Bateau(boatNumber),lig,col-1,true);
            this.repaint();          
            if(this.modele.isOutOfBounds() == false){                
                boatNumber --;
            }
            else{   

            }
        }
        else if(SwingUtilities.isRightMouseButton(e) && boatNumber >= 2){
            this.modele.placer(new Bateau(boatNumber),lig,col-1,false);            
            if(this.modele.isOutOfBounds() == false){                
                boatNumber --;
            }
            else{                

            }

        }
        else{
            try{
                this.modele.viserObus(lig,col-1,new Obus());
            }
            catch(Exception a){

            }
        }       
        //System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
		
}
