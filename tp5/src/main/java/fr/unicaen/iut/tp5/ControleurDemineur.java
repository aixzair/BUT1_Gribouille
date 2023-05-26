package fr.unicaen.iut.tp5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

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
			}
		});
	}
	
	private void initGrille(String userData) {
		int userDatas[];
		
		Background inconnu = new Background(new BackgroundFill(Color.AQUA, new CornerRadii(20), null));
        Background libre = new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), null));
        Background echec = new Background(new BackgroundFill(Color.RED, new CornerRadii(0), null));
        Background marquee = new Background(new BackgroundFill(Color.LEMONCHIFFON, new CornerRadii(0), null));
		
		this.grille.getColumnConstraints().clear();
        this.grille.getRowConstraints().clear();
        this.grille.setGridLinesVisible(true);
        
        userDatas = ModeleDemineur.parseUserData(userData);
        this.modele.setTaille(userDatas[0], userDatas[1], userDatas[2]);
        
        for (byte i = 0; i < userDatas[0]; i++) {
        	grille.getColumnConstraints().add(new ColumnConstraints(32));
        }
        
        for (byte i = 0; i < userDatas[1]; i++) {
        	grille.getRowConstraints().add(new RowConstraints(32));
        }
        
        for (byte lg = 0; lg < userDatas[1]; lg++) {
        	for (byte col = 0; col < userDatas[0]; col++) {
        		byte x = lg;
        		byte y = col;
    			
        		Label contenue = new Label("?");
        		
        		contenue.setAlignment(Pos.CENTER);
        		contenue.setBackground(inconnu);
        		contenue.setPrefHeight(31);
        		contenue.setPrefWidth(31);
        		contenue.textProperty().bind(this.modele.texteProperty(y, x));
        		contenue.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
        			if (!this.modele.estRevelee(y, x) && !this.modele.estPerdu()) {
	        			if (event.getButton() == MouseButton.PRIMARY) {
	        				this.modele.revele(y, x);
	        				
	        				if(this.modele.estPerdu()) {
	        					contenue.setBackground(echec);
	        				} else {
	        					contenue.setBackground(libre);
	        				}
	        			} else if (event.getButton() == MouseButton.SECONDARY) {
	        				this.modele.marque(y, x);
	        				contenue.setBackground(marquee);
	        			} else {
                            event.consume();
                        }
        			}
        		});
        		
        		this.grille.add(contenue, col, lg);
        	}
        }
	}
}
