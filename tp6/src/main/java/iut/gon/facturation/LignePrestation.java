package iut.gon.facturation;

import javax.persistence.ManyToOne;

public class LignePrestation extends Ligne {
	private @ManyToOne final Prestation prestation;

	public LignePrestation(final Prestation _prestation) {
		this.prestation = _prestation;
	}

}
