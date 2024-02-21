module org.example.mvp_academy {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.postgresql.jdbc;
    requires org.json;


    opens org.example.progetto to javafx.fxml;
    opens org.example.progetto.controllerui to javafx.fxml;
    opens org.example.progetto.controllerui.athlete to javafx.fxml;
    opens org.example.progetto.controllerui.trainer to javafx.fxml;
    exports org.example.progetto;
    exports org.example.progetto.controllerui;
    exports org.example.progetto.controllerui.trainer;
    exports org.example.progetto.controllerui.athlete;
    exports org.example.progetto.model;
    exports org.example.progetto.view;
}