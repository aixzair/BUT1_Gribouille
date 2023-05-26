package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ControleurDemineur {
	private ModeleDemineur modele;
	
	private @FXML ToggleGroup difficulte;
	private @FXML TextField inconues;
	private @FXML TextField marques;
	private @FXML GridPane grille;
		
	public ControleurDemineur(ModeleDemineur _modele) {
		this.modele = _modele;
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		this.inconues.textProperty().bind(this.modele.nbInconnuesProperty().asString());
		this.marques.textProperty().bind(this.modele.nbMarquesProperty().asString());
		
		difficulte.selectedToggleProperty().addListener(observable -> {
		   
		});
	}
	
	private void initGrille(String userData) {
		
	}

}
