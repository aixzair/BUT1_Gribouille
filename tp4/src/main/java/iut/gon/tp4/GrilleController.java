package iut.gon.tp4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class GrilleController
implements Initializable {

  private GrilleModel modele;
  private Scores table;

  public GrilleController(Scores score) {
	  this.table = score;
	  this.modele = new GrilleModel();
  }

  private @FXML GridPane grille;
  private @FXML HBox statut;
  private @FXML Label joueur;

  private Label[][] contenu = new Label[3][3];


  @Override
  public void initialize(URL location, ResourceBundle resources) {
    grille.setStyle("-fx-background-color: seashell");
    
    for (int l = 0; l < 3; ++l)
    	for (int c = 0; c < 3; ++c) {
    		int lg = l;
	        int col = c;
	        
	        Label label = new Label();
	        label.textProperty().bind(modele.getCase(l,c));
	        grille.add(label, c, l);
	        
	        label.setOnMouseClicked(event -> this.joueCase(lg, col));
	        label.setMaxSize(1000,1000);
	        label.setAlignment(Pos.CENTER);
	        label.setFont(Font.font(24));
    	}
    joueur.textProperty().bind(modele.texteJoueur);
  }

  public void joueCase(int lg, int col) {
    if (modele.estFinie()) return;
    
    try {
      modele.joueCase(lg, col);
    } catch (IllegalStateException ex) {
      new Alert(Alert.AlertType.ERROR,ex.getMessage()).showAndWait();
      
      return;
    }
    
    if (modele.estGagne(modele.JOUEUR_X))
      onGagne(modele.JOUEUR_X);
    else if (modele.estGagne(modele.JOUEUR_O))
      onGagne(modele.JOUEUR_O);
    else if (modele.estFinie())
      onGagne(null);
  }

  private void onGagne(String joueur) {
    //TODO demander le nom du joueur
    //TODO modifier scores
    //TODO appeler la table des scores
  }

  @FXML
  public void onMenuNouvelle(ActionEvent evt) {
	  // ...
  }
  @FXML
  public void onMenuTable(ActionEvent evt) {
	  FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
	  TableController controleur = fxmlLoader.getController();
	  
	  controleur.setScores(this.table);
	  this.grille.getScene().setRoot(this.statut);
  }

  @FXML
  public void onMenuQuitter(ActionEvent evt) {
    Platform.exit();
  }
}
