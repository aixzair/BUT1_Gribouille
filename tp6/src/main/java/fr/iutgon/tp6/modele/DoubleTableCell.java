package fr.iutgon.tp6.modele;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;

public class DoubleTableCell<T>
extends TableCell<T, Number> {
	
	public DoubleTableCell() {
		super();
	}

	@Override
	public void updateItem(Number item, boolean empty) {
		super.updateItem(item, empty);
		this.setAlignment(Pos.BASELINE_RIGHT);
		
		if (empty || item == null) {
			this.setGraphic(null);
		} else {
			this.setText(String.format("%.2f", item.floatValue()));
			
			if (item.floatValue() >= 0) {
				this.setTextFill(Color.BLUE);
			} else {
				this.setTextFill(Color.RED);
			}
		}
	}
}
