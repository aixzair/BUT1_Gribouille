package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable {
	private @FXML GridPane grille;
	
	public GrilleController() {
		
	}
	
	public void initialize(URL url, ResourceBundle resource) {
		grille.setStyle("-fx-background-color: seashell");
	}
}
