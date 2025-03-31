package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControleurCouleurs
implements Initializable {
	private Controleur controleur;
	
	private @FXML VBox vBox;
	private @FXML Rectangle recRouge;
	private @FXML Rectangle recVert;
	private @FXML Rectangle recBleu;
	private @FXML Rectangle recBleuClair;
	private @FXML Rectangle recRose;
	private @FXML Rectangle recJaune;
	private @FXML Rectangle recNoir;
	private @FXML Rectangle recBlanc;

	public ControleurCouleurs() {
		// Vide.
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (!(event.getTarget() instanceof Rectangle)) {
				return;
			}
			
			Rectangle rectangle = (Rectangle) event.getTarget();
			
			if (rectangle.getId() == recRouge.getId()) {
				this.controleur.setCouleur(Color.RED);
			} else if (rectangle.getId() == recVert.getId()) {
				this.controleur.setCouleur(Color.GREEN);
			} else if (rectangle.getId() == recBleu.getId()) {
				this.controleur.setCouleur(Color.DARKBLUE);
			} else if (rectangle.getId() == recBleuClair.getId()) {
				this.controleur.setCouleur(Color.BLUE);
			} else if (rectangle.getId() == recRose.getId()) {
				this.controleur.setCouleur(Color.PINK);
			} else if (rectangle.getId() == recJaune.getId()) {
				this.controleur.setCouleur(Color.YELLOW);
			} else if (rectangle.getId() == recNoir.getId()) {
				this.controleur.setCouleur(Color.BLACK);
			} else if (rectangle.getId() == recBlanc.getId()) {
				this.controleur.setCouleur(Color.WHITE);
			}
		});
	}
	
	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}
}
