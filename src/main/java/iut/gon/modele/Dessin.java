package iut.gon.modele;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 Stocke un dessin constitué de figures
 */
public class Dessin {
  /**
   Indique si le Dessin a été modifié depuis la dernière sauvegarde
   */
  private final SimpleBooleanProperty estModifie = new SimpleBooleanProperty(false);

  /**
   Le nom du fichier. Ou "Sans Nom", si non sauvegardé.
   */
  private final SimpleStringProperty nomDuFichier = new SimpleStringProperty("Sans Nom");
  /**
   La liste des figures
   */
  private List<Figure> figures;

  /**
   Crée un dessin vide sans nom
   */
  public Dessin() {
    figures = FXCollections.observableArrayList();
  }
  
  private SimpleObjectProperty<File> fichier = new SimpleObjectProperty<File>();
  
  /** Sauvegarde le dessin dans le fichier spécifié.
   *  Change le nom du dessin si succès.
   */
  public boolean sauveSous(String nom) {
    try {
      File nouveauFichier = new File(nom);
      PrintWriter out = new PrintWriter(nouveauFichier);
      this.nomDuFichier.set(nouveauFichier.getName());
      figures.forEach(f->f.sauve(out));
      out.close();
      this.fichier.set(nouveauFichier);
      estModifie.set(false);
      
      return true;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }
  
  /** Charge le dessin depuis le fichier spécifié.
   *  Change le nom du dessin si succès.
   * @throws IllegalArgumentException si le fichier est illisible
   */
  public void charge(String nom) {
    File nouveauFichier = new File(nom);
    this.nomDuFichier.set(nouveauFichier.getName());
    if (nouveauFichier.exists() && nouveauFichier.canRead()) {
      figures.clear();
      try {
        Scanner scanner = new Scanner(nouveauFichier);
        while (scanner.hasNextLine()) {
          String ligne = scanner.nextLine();
          if (! ligne.isBlank())
            figures.add(Figure.charge(ligne));
        }
        this.fichier.set(nouveauFichier);
        estModifie.set(false);
      } catch (FileNotFoundException e) {
        throw new IllegalArgumentException("Ce fichier est introuvable !");
      }
    } else {
      throw new IllegalArgumentException("Ce fichier est illisible !");
    }
  }

  /**
   Retourne La liste des figures
   */
  public List<Figure> getFigures() {
    return figures;
  }

  /**
   Modifie La liste des figures
   */
  public void setFigures(List<Figure> figures) {
    this.figures = figures;
  }

  /**
   Ajoute une nouvelle figure
   */
  public void addFigure(Figure figure) {
    figures.add(figure);
    estModifie.set(true);
  }

  /**
   Teste si le dessin a été modifié depuis la dernière sauvegarde
   */
  public boolean getEstModifie() {
    return estModifie.get();
  }

  /**
   Modifie l'état de modification du dessin
   */
  public void setEstModifie(boolean valeur) {
    estModifie.set(valeur);
  }

  /**
   Teste si le dessin a été modifié depuis la dernière sauvegarde
   */
  public BooleanExpression estModifieProperty() {
    return estModifie;
  }

  /**
   Retourne le nom du fichier
   */
  public String getNomDuFichier() {
    return nomDuFichier.get();
  }

  /**
   Retourne le nom du fichier
   */
  public void setNomDuFichier(String nomDuFichier) {
    this.nomDuFichier.set(nomDuFichier);
  }

  /**
   Le nom du fichier. Ou "Sans Nom", si non sauvegardé.
   */
  public StringExpression nomDuFichierProperty() {
    return nomDuFichier;
  }

} // public class Dessin
