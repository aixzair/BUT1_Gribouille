package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable {
	private @FXML GridPane grille;
	private int taille_tab = 3;
	private Label[][] labels = new Label[taille_tab][taille_tab];
	
	public GrilleController() {
		
	}
	
	public void initialize(URL url, ResourceBundle resource) {
		grille.setStyle("-fx-background-color: seashell");
		
		for (int lg = 0; lg < taille_tab; lg++) {
			for (int col = 0; col < taille_tab; col++) {
				int eventLg = lg;
				int eventCol = col;
				
				labels[col][lg] = new Label(String.format("L%dC%d", lg, col));
				labels[col][lg].setMaxSize(1000, 1000);
				labels[col][lg].setAlignment(Pos.CENTER);
				labels[col][lg].addEventHandler(
					MouseEvent.MOUSE_CLICKED,
					event -> {
						labels[eventLg][eventCol] = new Label("bonjour");
						grille.add(labels[eventLg][eventCol], eventLg, eventCol);
					}
				);
				
				grille.add(labels[col][lg], col, lg);
			}
		}
	}
}
