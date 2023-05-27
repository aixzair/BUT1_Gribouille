package fr.iutgon.tp6;

import fr.iutgon.tp6.modele.FabriqueProduits;
import fr.iutgon.tp6.modele.Ligne;
import fr.iutgon.tp6.modele.Produit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class FactureController implements Initializable {
	public TableView<Ligne> table;
	public TableColumn<Ligne, Integer> qte;
	public TableColumn<Ligne, Produit> produit;
	public TableColumn<Ligne, Number> prixUnitaire;
	public TableColumn<Ligne, Number> totalHT;
	public TableColumn<Ligne, Number> totalTTC;
	public TextField sommeFacture;
	
	/**
	 Called to initialize a controller after its root element has been completely processed.
	
	 @param location  The location used to resolve relative paths for the root object, or
	 {@code null} if the location is not known.
	 @param resources The resources used to localize the root object, or {@code null} if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
		this.produit.setCellValueFactory(ligneProduitCellDataFeatures -> {
            return ligneProduitCellDataFeatures.getValue().produitProperty();
        });
		this.prixUnitaire.setCellValueFactory(ligneNumberCellDataFeatures -> {
            return Bindings.selectFloat(ligneNumberCellDataFeatures.getValue().produitProperty(), "prix");
        });
		this.totalHT.setCellValueFactory(ligneNumberCellDataFeatures -> {
			return ligneNumberCellDataFeatures.getValue().totalHTProperty();
        });
		this.totalTTC.setCellValueFactory(ligneNumberCellDataFeatures -> {
			return ligneNumberCellDataFeatures.getValue().totalTTCProperty();
        });
	}
	
	public void onAjouter(ActionEvent actionEvent) {
		Random random = new Random();
		
		this.table.getItems().add(
			new Ligne(
				random.nextInt(100),
				FabriqueProduits.getProduits().get(random.nextInt(FabriqueProduits.getProduits().size()))
			)
		);
	}
}
