package iut.gon.gribouille;

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
    private ModeleDessin dessin;
    
	public ControleurDessin (ModeleDessin _dessin) {
		this.dessin = _dessin;
	}
	
	public void initialize() {
		this.canvas.widthProperty().bind(pane.widthProperty());
		this.canvas.heightProperty().bind(pane.heightProperty());
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
