package iut.gon.controleurs;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class ControleurMenus {
	private Controleur controleur;
	
	private @FXML ToggleGroup outils;
	private @FXML RadioMenuItem crayon;
	private @FXML RadioMenuItem etoile;

	public ControleurMenus() {
		// Vide.
	}
	
	public void initialize() {
		//ChangeListener outilsEcouteur = new ChangeListener();
		this.outils.getProperties().addListener(new ChangeListener());
	}
	
	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}
	
	public void onQuitte() {
		if (this.controleur.onQuitter()) {
			Platform.exit();
		}
	}
	
	// ------------ Gestion des évènements ------------
}
