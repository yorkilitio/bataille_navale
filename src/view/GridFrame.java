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



public class GridFrame{
    private static JLabel header;
    private static JPanel headerPanel;
    private static JPanel playerPanel;
    private static JPanel player1Panel;
    private static JPanel player2Panel;	
	private static Border border;
    private static Font labels = new Font("MV Boli", Font.PLAIN,20);
    private GridPanel p1;
    private GridPanel p2;

	Champ modele;
    Champ modele2;
	
	public GridFrame(Champ grid1, Champ grid2){
		super();
		this.modele = grid1;
        this.modele2 = grid2;		
		
	}

	public void displayFrame(){
		ImageIcon logo = new ImageIcon("images/logo.jpeg"); 
        
        //window frame
        JFrame mainFrame = new JFrame("Bataille Navale");
        mainFrame.setSize(1000,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout(10,10));
        mainFrame.setIconImage(logo.getImage());

        //header panel
        headerPanel = new JPanel();
        headerPanel.setBounds(0,0,250,250);

        //header text
        header = new JLabel("Bataille Navale");
        header.setFont(new Font("MV Boli", Font.PLAIN,30));
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        headerPanel.add(header);

		//player panel (which includes player1 and player2)
        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2));
        playerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        

        //player1 panel
        player1Panel = new JPanel();

        //player2 panel
        player2Panel = new JPanel();

		p1 = new GridPanel(this.modele);
		p2 = new GridPanel(this.modele2);

		mainFrame.add(headerPanel,BorderLayout.NORTH);
        mainFrame.add(playerPanel,BorderLayout.CENTER);
        playerPanel.add(p1,BorderLayout.CENTER);
        playerPanel.add(p2,BorderLayout.CENTER);
		mainFrame.setVisible(true);  
	}

    public GridPanel returnPanel1(){
        return this.p1;
    }
        public GridPanel returnPanel2(){
        return this.p2;
    }
	
	
	
	
	
}
