package iut.gon.tp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * @author Alexandre Lerosier
 * J'ai du faire le tp3 sans l'aide de prof pour raison médical
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage)
    throws IOException {
    	GrilleModel modele = new GrilleModel();
    	GrilleController controlleur = new GrilleController(modele);
    	
    	scene = new Scene(loadFXML("grille", controlleur), 640, 480);
    	
        stage.setScene(scene);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        	switch (event.getText()) {
        	case "a" : modele.setCase(0,0, "test"); break;
        	case "1" : modele.setCase(0,0, "Touche 1"); break;
        	case "2" : modele.setCase(0,1, "Touche 2"); break;
        	case "3" : modele.setCase(0,2, "Touche 3"); break;
        	case "4" : modele.setCase(1,0, "Touche 4"); break;
        	case "5" : modele.setCase(1,1, "Touche 5"); break;
        	case "6" : modele.setCase(1,2, "Touche 6"); break;
        	case "7" : modele.setCase(2,0, "Touche 7"); break;
        	case "8" : modele.setCase(2,1, "Touche 8"); break;
        	case "9" : modele.setCase(2,2, "Touche 9"); break;
        	}
    	});
    }

    static void setRoot(String fxml)
    throws IOException {
        scene.setRoot(loadFXML(fxml, null));
    }

    private static Parent loadFXML(String fxml, GrilleController controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controller);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}

/*

public class App extends Application {

private static Scene scene;

@Override
public void start(Stage stage) throws IOException {
    GrilleModel grilleMod = new GrilleModel();
    GrilleController grilleCont = new GrilleController(grilleMod);
    scene = new Scene(loadFXML("primary", grilleCont), 640, 480);
    stage.setScene(scene);
    stage.show();
    stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        switch (event.getText()) {
        case "1":
            grilleMod.setCase(0, 2, "Touche");
            break;
        case "2":
            grilleMod.setCase(1, 2, "Touche");
            break;
        case "3":
            grilleMod.setCase(2, 2, "Touche");
            break;
        case "4":
            grilleMod.setCase(0, 1, "Touche");
            break;
        case "5":
            grilleMod.setCase(1, 1, "Touche");
            break;
        case "6":
            grilleMod.setCase(2, 1, "Touche");
            break;
        case "7":
            grilleMod.setCase(0, 0, "Touche");
            break;
        case "8":
            grilleMod.setCase(1, 0, "Touche");
            break;
        case "9":
            grilleMod.setCase(2, 0, "Touche");
            break;
        }
    });
}

static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
}

private static Parent loadFXML(String fxml) throws IOException {
    // "iut.gon.tp3.GrilleController"
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
}

private static Parent loadFXML(String fxml, Object controller) throws IOException {
    // "iut.gon.tp3.GrilleController"
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    fxmlLoader.setController(controller);
    return fxmlLoader.load();
}

public static void main(String[] args) {
    launch();
}

}
*/