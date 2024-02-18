module org.example.mvp_academy {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.postgresql.jdbc;
    requires org.json;


    opens org.example.mvp_academy to javafx.fxml;
    exports org.example.mvp_academy;
    exports org.example.mvp_academy.controllerUI;
    exports org.example.mvp_academy.controllerUI.Trainer;
    exports org.example.mvp_academy.controllerUI.Athlete;
    exports org.example.mvp_academy.Model;
    exports org.example.mvp_academy.View;
}