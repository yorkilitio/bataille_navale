package view;

import model.*;
import game.*;
import players.*;

public class VueConsole implements ModelListener{
	
	Champ modele;
	
	
	public  VueConsole(Champ champ){
		this.modele = champ;
		// adding the view to the model
		this.modele.addListener(this);
	}
	
	
	@Override
	public void modelUpdated(Object source){
		System.out.println(source.toString());
	    System.out.println(this.modele.toString());
	}
	
	
}
