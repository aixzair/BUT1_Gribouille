package iut.gon.facturation;

public abstract class Element {
	protected final String titre;
	protected float prix;

	public Element(String _titre, float _prix) {
		this.titre = _titre;
		this.prix = _prix;
	}

}
