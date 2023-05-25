package fr.unicaen.iut.tp5;

public class ControleurDemineur {
	private ModeleDemineur modele;
	
	private @FXML TextField inconues;
	private @FXML TextField marques;
	private @FXML GridePane grille;
	
	objet."propriete"Property().bind(valeurAObserver);
	
	public ControleurDemineur(ModeleDemineur _modele) {
		this.modele = _modele;
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		this.inconues.TextProperty().bind(this.modele.getnbMarques);
	}

}
