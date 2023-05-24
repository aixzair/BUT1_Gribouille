package iut.gon.controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControleurStatut {
	private Controleur controleur;
	
	@FXML private Label sourisPosX;
    @FXML private Label sourisPosY;

	public ControleurStatut() {
		// TODO Auto-generated constructor stub
	}
	
	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}

}
