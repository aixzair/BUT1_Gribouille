package iut.gon.gribouille;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class Dialogues {

	public Dialogues() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * @return :
	 *	 - 0 : erreur.
	 *   - 1 : sauvegarder.
	 *   - 2 : ne pas sauvegarder.
	 *   - 3 : annuler.
	 */
	public static byte confirmation() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	
    	alert.setContentText("Voulez-vous sauvegarder avant de quitter l'application ?");
    	alert.getButtonTypes().clear();
    	alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
    	
    	ButtonType bouton = alert.showAndWait().get();
    	
    	if (bouton == ButtonType.YES) {
    		return 1;
    	} else if (bouton == ButtonType.NO) {
    		return 2;
    	} else if (bouton == ButtonType.CANCEL) {
    		return 3;
    	} else {
    		return 0;
    	}
	}

}
