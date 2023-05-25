package iut.gon.controleurs;

import iut.gon.gribouille.Dialogues;
import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controleur {
	private @FXML ControleurCouleurs couleursController;
	private @FXML ControleurDessin dessinController;
	private @FXML ControleurMenus menusController;
	private @FXML ControleurStatut statutController;
	
	public final Dessin dessin;
	public final SimpleDoubleProperty precX = new SimpleDoubleProperty();;
	public final SimpleDoubleProperty precY = new SimpleDoubleProperty();;
        
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);

	public Controleur(Dessin _dessin) {
		this.dessin = _dessin;
	}
	
	public void initialize() {
		this.couleursController.setParams(this);
		this.dessinController.setParams(this, this.dessin);
		this.menusController.setParams(this);
		this.statutController.setParams(this);
		
		this.statutController.getSourisPosX().textProperty().bind(this.precX.asString());
		this.statutController.getSourisPosY().textProperty().bind(this.precY.asString());
		this.statutController.getCouleur().textProperty().bind(this.couleur.asString());
		this.statutController.getEpaisseur().textProperty().bind(this.epaisseur.asString());
	}
	
	// ------------ Gestion des évènements ------------
	
	public boolean onQuitter() {
		return (!Dialogues.confirmation("Voulez-vous quitter l'application ?"));
	}
	
	public void onMousePressed(MouseEvent event) {
		this.precX.set(event.getX());
		this.precY.set(event.getY());
		this.dessin.addFigure(new Trace(3, "noir", this.precX.get(), this.precY.get()));
	}
	
	public void onMouseDragged(MouseEvent event) {
		this.dessinController.trace(
				this.precX.get(),
				this.precY.get(),
				event.getX(),
				event.getY()
		);
		
		Figure figure = this.dessin.getFigures().get(this.dessin.getFigures().size()-1);
		figure.addPoint(event.getX(), event.getY());
		
		this.precX.set(event.getX());
		this.precY.set(event.getY());
	}
	
	public void onMouseMoved(MouseEvent event) {
		this.precX.set(event.getX());
		this.precY.set(event.getY());
	}

}

/*

Figure figure = this.dessin.getFigures().get(this.dessin.getFigures().size()-1);
figure.addPoint(event.getX(), event.getY());

this.prevX.set(event.getX());
this.prevY.set(event.getY());
}

public void onMouseMoved(MouseEvent event) {
this.prevX.set(event.getX());
this.prevY.set(event.getY());
}
*/