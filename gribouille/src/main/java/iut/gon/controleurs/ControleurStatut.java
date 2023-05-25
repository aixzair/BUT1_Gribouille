package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControleurStatut {
	private Controleur controleur;
	
	@FXML private Label sourisPosX;
    @FXML private Label sourisPosY;
    @FXML private Label epaisseur;
    @FXML private Label couleur;

	public ControleurStatut() {
		// TODO Auto-generated constructor stub
	}
	
	public Label getSourisPosX() {
		return this.sourisPosX;
	}

	public Label getSourisPosY() {
		return this.sourisPosY;
	}

	public Label getEpaisseur() {
		return this.epaisseur;
	}

	public Label getCouleur() {
		return this.couleur;
	}

	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}

}
