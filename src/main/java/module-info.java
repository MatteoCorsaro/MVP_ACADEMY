module org.example.mvp_academy {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.postgresql.jdbc;
    requires org.json;


    opens org.example.mvp_academy to javafx.fxml;
    opens org.example.mvp_academy.controllerUI to javafx.fxml;
    opens org.example.mvp_academy.controllerUI.athlete to javafx.fxml;
    opens org.example.mvp_academy.controllerUI.trainer to javafx.fxml;
    exports org.example.mvp_academy;
    exports org.example.mvp_academy.controllerUI;
    exports org.example.mvp_academy.controllerUI.trainer;
    exports org.example.mvp_academy.controllerUI.athlete;
    exports org.example.mvp_academy.model;
    exports org.example.mvp_academy.view;
}