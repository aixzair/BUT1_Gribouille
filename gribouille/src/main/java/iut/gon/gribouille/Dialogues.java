package iut.gon.gribouille;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class Dialogues {

	public Dialogues() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean confirmation(String message) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	
    	alert.setContentText(message);
    	alert.getButtonTypes().clear();
    	alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
    	
    	if (alert.showAndWait().orElse(ButtonType.YES) == ButtonType.YES) {
    		return true;
    	} else {
    		return false;
    	}
	}

}
