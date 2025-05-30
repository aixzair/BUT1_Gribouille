package iut.gon.gribouille;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableStringValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.input.*;
import javafx.stage.Stage;

import java.io.IOException;

import iut.gon.controleurs.Controleur;
import iut.gon.modele.Dessin;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
    	Dessin modele = new Dessin();
    	Controleur controleur = new Controleur(modele, stage);
    	
        scene = new Scene(loadFXML("Gribouille", controleur), 640, 480);
        stage.setScene(scene);
        stage.setOnCloseRequest( event -> {
        	if (!controleur.onQuitter()) {
        		event.consume();
        	}
        });
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        	controleur.onKeyPressed(event.getText());
        });
        stage.show();
        stage.titleProperty().bind(
		    Bindings.when(modele.estModifieProperty())
					.then(Bindings.concat("*",  modele.nomDuFichierProperty()))
					.otherwise(modele.nomDuFichierProperty())
		);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml, null));
    }

    private static Parent loadFXML(String fxml, Object controleur) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controleur);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}