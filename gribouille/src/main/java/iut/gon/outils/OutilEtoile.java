package iut.gon.outils;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Etoile;
import iut.gon.modele.Figure;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.MouseEvent;

public class OutilEtoile
extends Outils {

	public OutilEtoile(Controleur _controleur) {
		super(_controleur);
	}
	
	// -------------- Evenement --------------
	
	public void onMousePressed(MouseEvent event) {
		super.controleur.dessin.addFigure( new Etoile(
			super.controleur.epaisseur.get(),
			super.controleur.couleur.toString(),
			super.controleur.precX.doubleValue(),
			super.controleur.precY.doubleValue()
		));
	}
	
	public void onMouseDragged(MouseEvent event) {
		super.controleur.getDessinController().trace(
			super.controleur.precX.get(),
			super.controleur.precY.get(),
			event.getX(),
			event.getY()
		);
		
		Figure figure = super.controleur.dessin.getFigures().get(super.controleur.dessin.getFigures().size()-1);
		figure.addPoint(event.getX(), event.getY());
	}

}
