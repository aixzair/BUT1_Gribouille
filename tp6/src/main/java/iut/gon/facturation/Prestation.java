package iut.gon.facturation;

public class Prestation extends Element {
	private double tva;

	public Prestation(String _titre, float _prix, double tva) {
		super(_titre, _prix);
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}
}
