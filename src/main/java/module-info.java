module com.quinteros.alonsomantenedor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.quinteros.alonsomantenedor to javafx.fxml;
    exports com.quinteros.alonsomantenedor;
}