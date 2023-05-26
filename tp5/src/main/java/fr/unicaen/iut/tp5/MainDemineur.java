package fr.unicaen.iut.tp5;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDemineur extends Application{
	private static Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		ModeleDemineur modele = new ModeleDemineur(10, 10, 10);
		ControleurDemineur controleur = new ControleurDemineur(modele);
		
		MainDemineur.scene = new Scene(loadFXML("demineur", controleur), 640, 480);
		stage.setTitle("démineur");
		stage.setScene(MainDemineur.scene);
		stage.show();
	}
	
	private static Parent loadFXML(String fichier, ControleurDemineur controleur)
	throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(MainDemineur.class.getResource(fichier + ".fxml"));
	    fxmlLoader.setController(controleur);
	    return fxmlLoader.load();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
