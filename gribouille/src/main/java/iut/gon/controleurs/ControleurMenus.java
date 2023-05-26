package iut.gon.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ControleurMenus
implements Initializable {
	private Controleur controleur;
	
	private @FXML ToggleGroup outils;
	private @FXML RadioMenuItem crayon;
	private @FXML RadioMenuItem etoile;
	private @FXML ToggleGroup groupe_epaisseur;

	public ControleurMenus() {
		// Vide.
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.outils.selectedToggleProperty().addListener(observable -> {
			if (crayon.isSelected()){
	            this.controleur.onCrayon();
	            this.controleur.getStatutController().getOutil().setText("crayon");
	        } else if (etoile.isSelected()) {
	        	this.controleur.onEtoile();
	        	this.controleur.getStatutController().getOutil().setText("étoile");
	        }
		});
		
		this.groupe_epaisseur.selectedToggleProperty().addListener(new ChangeListener<>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				controleur.setEpaisseur(newValue.getUserData().toString().charAt(0) - '0');
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
