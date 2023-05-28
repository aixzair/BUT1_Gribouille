package fr.iutgon.tp6.modele;

import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;

public class SetColonne extends TableCell {
	
	public SetColonne() {
		// Vide.
	}
	
	public void updateItem(Label item, boolean bool) {
		super.updateItem(item, bool);
		
		item.setAlignment(Pos.BASELINE_RIGHT);
		
		if (item.getText() == null) {
			item.setGraphic(null);
			item.setText(null);
		} else {
			String.format(item.getText(), 2);
		}
		
		item.setTextFill(Color.BLUE);
	}
	
	
}
