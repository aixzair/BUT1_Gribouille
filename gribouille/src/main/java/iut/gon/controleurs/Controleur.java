package iut.gon.controleurs;

import java.util.List;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controleur {
	private @FXML ControleurCouleurs controleurCouleurs = new ControleurCouleurs();
	private @FXML ControleurDessin controleurDessin = new ControleurDessin();
	private @FXML ControleurMenus controleurMenus = new ControleurMenus();
	private @FXML ControleurStatut controleurStatut  = new ControleurStatut();
	
	private Dessin dessin;
	private SimpleDoubleProperty prevX;
    private SimpleDoubleProperty prevY;
        
    private final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
    private final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);

	public Controleur(Dessin _dessin) {
		this.dessin = _dessin;
	}
	
	public void initialize() {
		this.controleurCouleurs.setParams(this);
		this.controleurDessin.setParams(this);
		this.controleurMenus.setParams(this);
		this.controleurStatut.setParams(this);
	}
	
	

}

/*
this.prevX = new SimpleDoubleProperty();
this.prevY = new SimpleDoubleProperty();

this.sourisPosX.textProperty().bind(this.prevX.asString());
this.sourisPosY.textProperty().bind(this.prevY.asString());
*/

/*

public void onMousePressed(MouseEvent event) {
this.prevX.set(event.getX());
this.prevY.set(event.getY());

this.dessin.addFigure(new Trace(3, "noir", this.prevX.get(), this.prevY.get()));
}

public void onMouseDragged(MouseEvent event) {
this.canvas .getGraphicsContext2D().strokeLine(
		this.prevX.get(),
		this.prevY.get(),
		event.getX(),
		event.getY()
);

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