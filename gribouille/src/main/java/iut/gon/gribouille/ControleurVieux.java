package iut.gon.gribouille;

import java.util.List;

import iut.gon.modele.Dessin;
import iut.gon.modele.Figure;
import iut.gon.modele.Point;
import iut.gon.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleurVieux {
	@FXML private Pane pane;
    @FXML private Canvas canvas;
    @FXML private Label sourisPosX;
    @FXML private Label sourisPosY;
    
    private SimpleDoubleProperty prevX;
    private SimpleDoubleProperty prevY;
    private Dessin dessin;
    
	public ControleurVieux (Dessin _dessin) {
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
		
		this.prevX = new SimpleDoubleProperty();
		this.prevY = new SimpleDoubleProperty();
		
		this.sourisPosX.textProperty().bind(this.prevX.asString());
		this.sourisPosY.textProperty().bind(this.prevY.asString());
	}
	
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
}
