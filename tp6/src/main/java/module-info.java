module fr.iutgon.tp6 {
  requires javafx.controls;
  requires javafx.fxml;
requires javafx.base;
requires javafx.graphics;


  opens fr.iutgon.tp6 to javafx.fxml;
  exports fr.iutgon.tp6;
  exports fr.iutgon.tp6.modele;
}