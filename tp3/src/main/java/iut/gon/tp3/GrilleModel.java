package iut.gon.tp3;

import javafx.beans.property.SimpleStringProperty;

public class GrilleModel {
	private final byte taille_tab = 3;
	private SimpleStringProperty[][] cases;
	
	public GrilleModel() {
		this.cases = new SimpleStringProperty[taille_tab][taille_tab];
		
		for (int lg = 0; lg < this.taille_tab; lg++) {
			for (int col = 0; col < this.taille_tab; col++) {
				this.cases[lg][col] = new SimpleStringProperty();
				this.cases[lg][col].setValue(String.format("L%dC%d", lg, col));
			}
		}
	}
	
	public String getCase(int lg, int col) {
		return this.cases[lg][col].getValue();
	}
	
	public void setCase(int lg, int col, String texte) {
		this.cases[lg][col].setValue(texte);
	}
	
	SimpleStringProperty caseProperty(int lg, int col) {
        return this.cases[lg][col];
    }

}