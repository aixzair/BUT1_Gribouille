package iut.gon.facturation;

import java.util.ArrayList;

import javax.persistence.OneToMany;

import iut.gon.tp6.Customer;

public class Facture {
	private final Customer client;
	private @OneToMany ArrayList<Ligne> lignes = new ArrayList<Ligne>();

	public Facture(Customer _client) {
		this.client = _client;
	}
	
	public void ajouterLigne(Ligne ligne) {
		this.lignes.add(ligne);
	}

}
