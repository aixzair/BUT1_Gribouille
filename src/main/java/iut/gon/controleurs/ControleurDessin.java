package iut.gon.controleurs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleurDessin
implements Initializable {
	private Controleur controleur;
	private Dessin modele;
	
	@FXML private Pane pane;
    @FXML private Canvas canvas;

	public ControleurDessin() {
		// Vide.
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.canvas.widthProperty().bind(this.pane.widthProperty());
		this.canvas.heightProperty().bind(this.pane.heightProperty());
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public void setParams(Controleur _controleur, Dessin _modele) {
		this.controleur = _controleur;
		this.modele = _modele;
		this.controleur.dessine();
	}
	
	public void setEpaisseur(int epaisseur) {
		this.canvas.getGraphicsContext2D().setLineWidth(epaisseur);
	}
	
	public void efface() {
		this.canvas.getGraphicsContext2D().clearRect(
			0,
			0,
			this.modele.getFigures().size(),
			this.modele.getFigures().get(0).getPoints().size()
		);
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		this.canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	
	// ------------ Gestion des évènements ------------
	
	public void onMousePressed(MouseEvent event) {
		this.controleur.onMousePressed(event);
	}
	
	public void onMouseMoved(MouseEvent event) {
		this.controleur.onMouseMoved(event);
	}
	
	public void onMouseDragged(MouseEvent event) {
		this.controleur.onMouseDragged(event);
	}
}