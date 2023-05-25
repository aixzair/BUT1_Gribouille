package iut.gon.outils;

import iut.gon.controleurs.Controleur;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.MouseEvent;

public abstract class Outils {
	protected Controleur controleur;
	
	public abstract void onMousePressed(MouseEvent event);
	
	public abstract void onMouseDragged(MouseEvent event);
		
	public Outils(Controleur _controleur) {
		this.controleur = _controleur;
	}
}
