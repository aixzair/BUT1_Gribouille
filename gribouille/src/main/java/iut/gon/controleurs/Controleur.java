package iut.gon.controleurs;

import java.util.List;

import iut.gon.gribouille.Dialogues;
import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import iut.gon.outils.OutilCrayon;
import iut.gon.outils.OutilEtoile;
import iut.gon.outils.Outils;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controleur {
	public final Dessin dessin;
	public final SimpleDoubleProperty precX = new SimpleDoubleProperty();
	public final SimpleDoubleProperty precY = new SimpleDoubleProperty();
	
	private Outils outils = new OutilCrayon(this);
        
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	private @FXML ControleurCouleurs couleursController;
	private @FXML ControleurDessin dessinController;
	private @FXML ControleurMenus menusController;
	private @FXML ControleurStatut statutController;

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
		this.statutController.getEpaisseur().textProperty().bind(this.epaisseur.asString());
		this.statutController.getOutil().setText("crayon");
		this.statutController.getCouleur().textProperty().bind(this.couleur.asString());
	}
	
	public Outils getOutils() {
		return this.outils;
	}
	
	public ControleurDessin getDessinController() {
		return this.dessinController;
	}
	
	public ControleurStatut getStatutController() {
		return this.statutController;
	}
	
	public void onCrayon() {
		this.outils = new OutilCrayon(this);
	}
	
	public void onEtoile() {
		this.outils = new OutilEtoile(this);
	}
	
	public void dessine() {
		this.dessinController.getCanvas().widthProperty().addListener((objet) -> {
			for (Figure figure: this.dessin.getFigures()) {
				List<Point> points = figure.getPoints();
				
				for (int i = 0; i < points.size() - 1; i++) {
					this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
						points.get(i).getX(),
						points.get(i).getY(),
						points.get(i+1).getX(),
						points.get(i+1).getY()
					);
				}
			}
		});
		this.dessinController.getCanvas().heightProperty().addListener((objet) -> {
			for (Figure figure: this.dessin.getFigures()) {
				List<Point> points = figure.getPoints();
				
				for (int i = 0; i < points.size() - 1; i++) {
					this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
						points.get(i).getX(),
						points.get(i).getY(),
						points.get(i+1).getX(),
						points.get(i+1).getY()
					);
				}
			}
		});
	}
	
	// ------------ Gestion des évènements ------------
	
	public boolean onQuitter() {
		return (!Dialogues.confirmation("Voulez-vous quitter l'application ?"));
	}
	
	public void onMousePressed(MouseEvent event) {
		this.outils.onMousePressed(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		this.outils.onMouseDragged(event);
	}
	
	public void onMouseMoved(MouseEvent event) {
		this.precX.set(event.getX());
		this.precY.set(event.getY());
	}

}