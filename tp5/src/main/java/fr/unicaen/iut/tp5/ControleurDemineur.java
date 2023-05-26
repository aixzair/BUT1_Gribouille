package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class ControleurDemineur {
	private ModeleDemineur modele;
	
	private @FXML ToggleGroup difficulte;
	private @FXML TextField inconues;
	private @FXML TextField marques;
	private @FXML GridPane grille;
		
	public ControleurDemineur(ModeleDemineur _modele) {
		this.modele = _modele;
	}
	
	public void initialize() {
		this.initGrille("10;10;10");
		
		this.inconues.textProperty().bind(this.modele.nbInconnuesProperty().asString());
		this.marques.textProperty().bind(this.modele.nbMarquesProperty().asString());
		
		difficulte.selectedToggleProperty().addListener(new ChangeListener<>() {
			
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				initGrille((String) newValue.getUserData());
				System.out.println("changed");
			}
		});
	}
	
	private void initGrille(String userData) {
		int userDatas[];
		
		grille.getColumnConstraints().clear();
        grille.getRowConstraints().clear();
        grille.setGridLinesVisible(true); 
        
        userDatas = ModeleDemineur.parseUserData(userData);
        this.modele.setTaille(userDatas[0], userDatas[1], userDatas[2]);
        
        for (byte i = 0; i < userDatas[0]; i++) {
        	grille.getColumnConstraints().add(new ColumnConstraints(32));
        }
        
        for (byte i = 0; i < userDatas[1]; i++) {
        	grille.getRowConstraints().add(new RowConstraints(32));
        }
	}
}
