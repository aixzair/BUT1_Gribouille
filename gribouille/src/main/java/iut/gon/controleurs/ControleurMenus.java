package iut.gon.controleurs;

import javafx.application.Platform;
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
		this.outils.selectedToggleProperty().addListener(observable -> {
			if (crayon.isSelected()){
	            this.controleur.onCrayon();
	            this.controleur.getStatutController().getOutil().setText("crayon");
	        } else if (etoile.isSelected()) {
	        	this.controleur.onEtoile();
	        	this.controleur.getStatutController().getOutil().setText("étoile");
	        }
		});
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
