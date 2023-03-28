module iut.gon.tp {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.tp to javafx.fxml;
    exports iut.gon.tp;
}
