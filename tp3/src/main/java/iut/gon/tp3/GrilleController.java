package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GrilleController
implements Initializable {
	private @FXML GridPane grille;
	
	private int taille_tab = 3;
	private Label[][] labels = new Label[taille_tab][taille_tab];
	
	private GrilleModel model;
	
	public GrilleController(GrilleModel model) {
		this.model = model;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		grille.setStyle("-fx-background-color: seashell");
		
		for (int lg = 0; lg < taille_tab; lg++) {
			for (int col = 0; col < taille_tab; col++) {
				int eventLg = lg;
				int eventCol = col;
				
				this.labels[col][lg] = new Label();
				this.labels[col][lg].textProperty().bind(model.caseProperty(lg, col));
				this.labels[col][lg].setMaxSize(1000, 1000);
				this.labels[col][lg].setAlignment(Pos.CENTER);
				
				this.labels[eventCol][eventLg].addEventHandler(
					MouseEvent.MOUSE_CLICKED,
					event -> {
						this.model.setCase(eventLg, eventCol, "bonjour");
						this.labels[eventCol][eventLg].setText(this.model.getCase(eventLg, eventCol));
					}
				);
				
				grille.add(labels[col][lg], col, lg);
			}
		}
	}
}
