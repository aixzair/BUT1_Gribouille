package iut.gon.facturation;

import javax.persistence.ManyToOne;

public class LigneProduit extends Ligne {
	private @ManyToOne final Produit produit;
	private int quantite;

	public LigneProduit(Produit _produit, int _quantite) {
		this.produit = _produit;
		this.quantite = _quantite;
	}

}
