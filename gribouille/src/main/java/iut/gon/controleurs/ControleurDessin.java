package iut.gon.controleurs;

import java.util.List;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleurDessin {
	private Controleur controleur;
	private Dessin modele;
	
	@FXML private Pane pane;
    @FXML private Canvas canvas;

	public ControleurDessin() {
		// Vide.
	}
	
	public void initialize() {
		this.canvas.widthProperty().bind(this.pane.widthProperty());
		this.canvas.heightProperty().bind(this.pane.heightProperty());
		
		this.dessine();
	}
	
	public void setParams(Controleur _controleur, Dessin _modele) {
		this.controleur = _controleur;
		this.modele = _modele;
	}
	
	public void dessine() {
		this.canvas.widthProperty().addListener((objet) -> {
			for (Figure figure: this.modele.getFigures()) {
				List<Point> points = figure.getPoints();
				
				for (int i = 0; i < points.size() - 1; i++) {
					this.canvas.getGraphicsContext2D().strokeLine(
						points.get(i).getX(),
						points.get(i).getY(),
						points.get(i+1).getX(),
						points.get(i+1).getY()
					);
				}
			}
		});
		this.canvas.heightProperty().addListener((objet) -> {
			for (Figure figure: this.modele.getFigures()) {
				List<Point> points = figure.getPoints();
				
				for (int i = 0; i < points.size() - 1; i++) {
					this.canvas.getGraphicsContext2D().strokeLine(
						points.get(i).getX(),
						points.get(i).getY(),
						points.get(i+1).getX(),
						points.get(i+1).getY()
					);
				}
			}
		});
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