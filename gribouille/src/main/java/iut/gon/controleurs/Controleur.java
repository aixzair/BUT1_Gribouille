package iut.gon.controleurs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille.Dialogues;
import iut.gon.modele.Dessin;
import iut.gon.modele.Etoile;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import iut.gon.modele.Trace;
import iut.gon.outils.OutilCrayon;
import iut.gon.outils.OutilEtoile;
import iut.gon.outils.Outils;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controleur
implements Initializable {
	public final Dessin dessin;
	public final SimpleDoubleProperty precX = new SimpleDoubleProperty();
	public final SimpleDoubleProperty precY = new SimpleDoubleProperty();
	
	private Outils outils = new OutilCrayon(this);
        
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	private final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	private @FXML ControleurCouleurs couleursController;
	private @FXML ControleurDessin dessinController;
	private @FXML ControleurMenus menusController;
	private @FXML ControleurStatut statutController;

	public Controleur(Dessin _dessin) {
		this.dessin = _dessin;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.couleursController.setParams(this);
		this.dessinController.setParams(this, this.dessin);
		this.menusController.setParams(this);
		this.statutController.setParams(this);
		
		this.statutController.getSourisPosX().textProperty().bind(
			Bindings.createLongBinding(
				() -> Math.round(this.precX.get()),
				this.precX
			).asString()
		);
		this.statutController.getSourisPosY().textProperty().bind(
			Bindings.createLongBinding(
				() -> Math.round(this.precY.get()),
				this.precY
			).asString()
		);
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
	
	public SimpleIntegerProperty getEpaisseur() {
		return this.epaisseur;
	}
	
	public void setCouleur(Color _couleur) {
		this.couleur.set(_couleur);
		this.dessinController.getCanvas().getGraphicsContext2D().setStroke(_couleur);
	}
	
	public void setEpaisseur(int _epaisseur) {
		this.epaisseur.set(_epaisseur);
		this.dessinController.setEpaisseur(_epaisseur);
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
				this.setCouleur(Color.valueOf(figure.getCouleur()));
				
				if (figure instanceof Trace) {
					for (int i = 0; i < points.size() - 1; i++) {
						this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
							points.get(i).getX(),
							points.get(i).getY(),
							points.get(i+1).getX(),
							points.get(i+1).getY()
						);
					}
				} else if (figure instanceof Etoile) {
					Etoile etoile = (Etoile) figure;
					
					for (int i = 0; i < points.size() - 1; i++) {
						this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
							points.get(i).getX(),
							points.get(i).getY(),
							etoile.getCentre().getX(),
							etoile.getCentre().getY()
						);
					}
				}
			}
		});
		this.dessinController.getCanvas().heightProperty().addListener((objet) -> {
			for (Figure figure: this.dessin.getFigures()) {
				List<Point> points = figure.getPoints();
				this.setCouleur(Color.valueOf(figure.getCouleur()));
				
				if (figure instanceof Trace) {
					for (int i = 0; i < points.size() - 1; i++) {
						this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
							points.get(i).getX(),
							points.get(i).getY(),
							points.get(i+1).getX(),
							points.get(i+1).getY()
						);
					}
				} else if (figure instanceof Etoile) {
					Etoile etoile = (Etoile) figure;
					
					for (int i = 0; i < points.size() - 1; i++) {
						this.dessinController.getCanvas().getGraphicsContext2D().strokeLine(
							points.get(i).getX(),
							points.get(i).getY(),
							etoile.getCentre().getX(),
							etoile.getCentre().getY()
						);
					}
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
	
	public void onKeyPressed(String touche) {
		switch (touche) {
		case "&":
		case "1":
			this.setEpaisseur(1);
		break;
		
		case "é":
		case "2":
			this.setEpaisseur(2);
		break;
		case "\"":
		case "3":
			this.setEpaisseur(3);
		break;
		
		case "'":
		case "4":
			this.setEpaisseur(4);
		break;
		
		case "(":
		case "5":
			this.setEpaisseur(5);
		break;
		
		case "-":
		case "6":
			this.setEpaisseur(6);
		break;
		
		case "è":
		case "7":
			this.setEpaisseur(7);
		break;
		
		case "_":
		case "8":
			this.setEpaisseur(8);
		break;
		
		case "ç":
		case "9":
			this.setEpaisseur(9);
			
		break;
		
		case "c":
			if (this.couleur.get().toString().equals(Color.RED.toString())) {
				this.setCouleur(Color.GREEN);
			} else if (this.couleur.get().toString().equals(Color.GREEN.toString())) {
				this.setCouleur(Color.DARKBLUE);
			} else if (this.couleur.get().toString().equals(Color.DARKBLUE.toString())) {
				this.setCouleur(Color.BLUE);
			} else if (this.couleur.get().toString().equals(Color.BLUE.toString())) {
				this.setCouleur(Color.PINK);
			} else if (this.couleur.get().toString().equals(Color.PINK.toString())) {
				this.setCouleur(Color.YELLOW);
			} else if (this.couleur.get().toString().equals(Color.YELLOW.toString())) {
				this.setCouleur(Color.BLACK);
			} else if (this.couleur.get().toString().equals(Color.BLACK.toString())) {
				this.setCouleur(Color.WHITE);
			} else if (this.couleur.get().toString().equals(Color.WHITE.toString())) {
				this.setCouleur(Color.RED);
			} else {
				this.setCouleur(Color.BLACK);
			}
		break;
		
		case "e":
			this.setEpaisseur((this.getEpaisseur().get() % 9) + 1);
		break;
		
		case "o":
			if (this.outils instanceof OutilCrayon) {
				this.onEtoile();
			} else if (this.outils instanceof OutilEtoile){
				this.onCrayon();
			}
		break;
		}
	}
}