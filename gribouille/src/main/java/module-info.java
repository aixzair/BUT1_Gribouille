module iut.gon.gribouille {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;

    opens iut.gon.gribouille to javafx.fxml;
    exports iut.gon.gribouille;
    opens iut.gon.controleurs to javafx.fxml;
    exports iut.gon.controleurs;
}