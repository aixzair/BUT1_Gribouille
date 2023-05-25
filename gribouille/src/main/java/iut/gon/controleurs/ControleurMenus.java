package iut.gon.controleurs;

import javafx.application.Platform;

public class ControleurMenus {
	private Controleur controleur;

	public ControleurMenus() {
		// Vide.
	}
	
	public void setParams(Controleur _controleur) {
		this.controleur = _controleur;
	}
	
	public void onQuitte() {
		if (this.controleur.onQuitter()) {
			Platform.exit();
		}
	}
	
	// ------------ Gestion des évènements ------------
}
