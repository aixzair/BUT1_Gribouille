package iut.gon.tp6;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.h2.tools.Server;

import iut.gon.facturation.*;

public class Application {
	/*
	 * 
	 */

    public static void main(String[] args)
    throws SQLException {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = new Customer();
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:./dbs:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");
    	
        Produit produit =  new Produit("ordinateur", 1000);
    	Prestation prestation = new Prestation("montage", 100, 20);
    	
    	LigneProduit ligneProd = new LigneProduit(produit, 1);
    	LignePrestation lignePrest = new LignePrestation(prestation);
    	
    	Customer client = new Customer();
    	client.setFirstName("Alexandre");
    	client.setLastName("Lerosier");
    	client.setId(0);
    	
    	Facture facture = new Facture(client);
    	facture.ajouterLigne(ligneProd);
    	facture.ajouterLigne(lignePrest);
    	
    	entityManager.getTransaction().begin();
        entityManager.persist(produit);
        entityManager.persist(prestation);
        entityManager.persist(ligneProd);
        entityManager.persist(lignePrest);
        entityManager.persist(client);
        entityManager.persist(facture);
        entityManager.getTransaction().commit();
        
        Query query = entityManager.createQuery("HQL from Facture");
		ArrayList<Facture> resulats = (ArrayList<Facture>) query.getResultList();
        
        for (int i = 0; i < resultats.length(); i++) {
        	
        }
        

    }
    
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
