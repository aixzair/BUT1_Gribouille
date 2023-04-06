package iut.gon.tp2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TP2App extends Application {

  private BorderPane contenu;
  private ListView<String> gauche;
  private ListView<String> droite;
  private Button versGauche;
  private Button versDroite;
  private Button retireTout;
  private Button ajouteTout;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(TP2App.class.getResource("Tp2.fxml"));
    contenu = fxmlLoader.load();
    Scene scene = new Scene(contenu);
    extraitIds(scene);

    prepareMenus((MenuBar) scene.lookup("#menus"));
    prepareListe();
    prepareBoutons();
    prepareFermeture(stage);

    stage.setTitle("Gestion de groupe");
    stage.setScene(scene);
    stage.show();
  }

  /** Prépare la fenêtre pour demander confirmation avant fermeture */
  private void prepareFermeture(Stage stage) {
    stage.setOnCloseRequest(event -> {
      //TODO confirmer ou consommer l'événement
    });
  }

  /** Prépare les actions des boutons */
  private void prepareBoutons() {
    ajouteTout.setOnAction(this::onAjouteTout);
    retireTout.setOnAction(this::onRetireTout);
    this.versDroite.setOnAction(this::onVersDroite);
    this.versGauche.setOnAction(this::onVersGauche);
  }

  /** Ajoute tous les éléments de gauche dans la liste de droite
   Active le bouton "Retirer tout" et désactive le bouton "Ajouter tout" */
  private void onAjouteTout(ActionEvent actionEvent) {
    droite.getItems().addAll(gauche.getItems());
    gauche.getItems().clear();
    //TODO active/désactive les boutons
  }

  /** Ajoute tous les éléments de droite dans la liste de gauche
   Active le bouton "Ajouter tout" et désactive le bouton "Retirer tout" */
  private void onRetireTout(ActionEvent actionEvent) {
	  gauche.getItems().addAll(droite.getItems());
	  droite.getItems().clear();
  }
  
  private void onVersDroite(ActionEvent actionEvent) {
	  int index = this.gauche.getSelectionModel().getSelectedIndex();
	  
	  if (index != -1) {
		  this.droite.getItems().add(this.gauche.getItems().get(index));
		  this.gauche.getItems().remove(index);
		  this.gauche.getSelectionModel().clearSelection();
	  }
  }
  
  private void onVersGauche(ActionEvent actionEvent) {
	  int index = this.droite.getSelectionModel().getSelectedIndex();
	  
	  if (index != -1) {
		  this.gauche.getItems().add(this.droite.getItems().get(index));
		  this.droite.getItems().remove(index);
		  this.droite.getSelectionModel().clearSelection();
	  }
  }

  /** Prépare les menus et leurs événements */
  private void prepareMenus(MenuBar menus) {
    Menu fichiers = new Menu("_Fichiers");
    Menu aide = new Menu("_Aide");
    
    menus.getMenus().addAll(fichiers, aide);
    
    MenuItem quitter = new MenuItem("Quitter");
    MenuItem propos = new MenuItem("À propos");
    
    fichiers.getItems().add(quitter);
    aide.getItems().add(propos);
    
    quitter.addEventHandler(
    		ActionEvent.ACTION, 
    		(e) -> { 
    			Platform.exit();
    		}
    );
    
    propos.addEventHandler(
    		ActionEvent.ACTION,
    		(e) -> { 
    			Alert alert = new Alert(
    					AlertType.NONE,
    					"Faits par Alexandre Lerosier.",
    					ButtonType.CLOSE
    			);
    			
    			alert.setTitle("À propos");
    			alert.show();
    		}
    );
  }

  /**
   Remplit la liste de gauche avec des valeurs
   Active le bouton "Ajouter tout"
   */
  private void prepareListe() {
    this.gauche.getItems().addAll("Element 1", "Element 2");
    this.ajouteTout.setDisable(false);
    this.retireTout.setDisable(false);
  }

  private void extraitIds(Scene scene) {
    gauche = (ListView<String>) scene.lookup("#gauche");
    droite = (ListView<String>) scene.lookup("#droite");
    versGauche = (Button) scene.lookup("#versGauche");
    versDroite = (Button) scene.lookup("#versDroite");
    retireTout = (Button) scene.lookup("#retireTout");
    ajouteTout = (Button) scene.lookup("#ajouteTout");
  }

  public static void main(String[] args) {
    launch();
  }
}
