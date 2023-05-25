package fr.unicaen.iut.tp5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainDemineur extends Application{
	ModeleDemineur modele = new ModeleDemineur();
	ControleurDemineur controleur = new ControleurDemineur();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(new Label("Ok !"), 800, 600));
		stage.show();
	}
	
	private static Parent loadFXML(String fichier, Controleur controleur)
	throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(monApplication.class.getResource(fichier + ".fxml"));
	    fxmlLoader.setController(controleur);
	    return fxmlLoader.load();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
