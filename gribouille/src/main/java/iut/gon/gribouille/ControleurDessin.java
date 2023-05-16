package iut.gon.gribouille;

import java.util.List;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleurDessin {
	@FXML private Pane pane;
    @FXML private Canvas canvas;
    @FXML private Label sourisPosX;
    @FXML private Label sourisPosY;
    
    private double prevX;
    private double prevY;
    private Dessin dessin;
    
	public ControleurDessin (Dessin _dessin) {
		this.dessin = _dessin;
	}
	
	public void initialize() {
		this.canvas.widthProperty().bind(pane.widthProperty());
		this.canvas.heightProperty().bind(pane.heightProperty());
		this.canvas.widthProperty().addListener((obs) -> {
			for (Figure figure: dessin.getFigures()) {
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
		this.canvas.heightProperty().addListener((obs) -> {
			for (Figure figure: dessin.getFigures()) {
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
	
	public void onMousePressed(MouseEvent event) {
		this.prevX = event.getSceneX();
		this.prevY = event.getSceneY();
	}
	
	public void onMouseDragged(MouseEvent event) {
		this.canvas.getGraphicsContext2D().strokeLine(
				this.prevX,
				this.prevY,
				event.getX(),
				event.getY()
		);
		
		this.prevX = event.getSceneX();
		this.prevY = event.getSceneY();
	}
}
