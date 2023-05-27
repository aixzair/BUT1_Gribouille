package iut.gon.outils;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Figure;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.MouseEvent;

public class OutilCrayon
extends Outils {

	public OutilCrayon(Controleur _controleur) {
		super(_controleur);
	}
	
	// -------------- Evenement --------------
	
	@Override
	public void onMousePressed(MouseEvent event) {
		super.controleur.precX.set(event.getX());
		super.controleur.precY.set(event.getY());
		super.controleur.dessin.addFigure(
			new Trace(
				super.controleur.getEpaisseur().get(),
				super.controleur.couleur.get().toString(),
				super.controleur.precX.get(),
				this.controleur.precY.get()
			)
		);
	}
	
	@Override
	public void onMouseDragged(MouseEvent event) {
		super.controleur.getDessinController().trace(
				super.controleur.precX.get(),
				super.controleur.precY.get(),
				event.getX(),
				event.getY()
		);
		
		Figure figure = super.controleur.dessin.getFigures().get(super.controleur.dessin.getFigures().size()-1);
		figure.addPoint(event.getX(), event.getY());
		figure.changeCouleur(super.controleur.couleur.get().toString());
		
		super.controleur.precX.set(event.getX());
		super.controleur.precY.set(event.getY());
	}
}
