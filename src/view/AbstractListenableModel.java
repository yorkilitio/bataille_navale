package view;

import java.util.ArrayList;
import model.*;
import game.*;
import players.*;

public class AbstractListenableModel{
	ArrayList<ModelListener> abonnes;
	
	public AbstractListenableModel(){
		this.abonnes = new ArrayList<>();
	}
	
	public void addListener(ModelListener e){
		this.abonnes.add(e);
		//System.out.println("Model Listener");
	}
	
	public void removeListener(ModelListener e){
		this.abonnes.remove(e);
	}
	
	protected void  fireChange(){
		for(ModelListener a : abonnes){
			a.modelUpdated(this);
		}
		//System.out.println("Fire change");		
	}
	
	
}
