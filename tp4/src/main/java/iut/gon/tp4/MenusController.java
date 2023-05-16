package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MenusController {
	private @FXML MenuBar menuBarMen;
	
	private GrilleModel modele;
	private Scores table;
	
	public void setParams(GrilleModel _modele, Scores _table) {
		this.modele = _modele;
		this.table = _table;
	}

	@FXML
	public void onMenuNouvelle(ActionEvent evt) {
	  // ...
	}
	
	@FXML
	public void onMenuTable(ActionEvent evt)
	throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
		TableController controleur = fxmlLoader.getController();
			  
		controleur.setScores(this.table);
		this.menuBarMen.getScene().setRoot(fxmlLoader.load());
	}

	@FXML
	public void onMenuQuitter(ActionEvent evt) {
	    Platform.exit();
	}
}
