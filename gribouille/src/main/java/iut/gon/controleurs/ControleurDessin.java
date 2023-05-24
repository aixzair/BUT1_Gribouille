package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class ControleurDessin {
	private Controleur controleur;
	
	@FXML private Pane pane;
    @FXML private Canvas canvas;

	public ControleurDessin() {
		// TODO Auto-generated constructor stub
	}
	
	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}

}

/*
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


*/