module com.quinteros.alonsomantenedor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;



    opens com.quinteros.alonsomantenedor to javafx.fxml;
    opens com.quinteros.alonsomantenedor.controller to javafx.fxml;
    opens com.quinteros.alonsomantenedor.dto to javafx.fxml, com.google.gson, javafx.base;

    exports com.quinteros.alonsomantenedor;
    exports com.quinteros.alonsomantenedor.dto;


}
