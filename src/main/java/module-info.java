module org.example.mvp_academy {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.postgresql.jdbc;
    requires org.json;


    opens org.example.mvpAcademy to javafx.fxml;
    opens org.example.mvpAcademy.controllerUI to javafx.fxml;
    opens org.example.mvpAcademy.controllerUI.athlete to javafx.fxml;
    opens org.example.mvpAcademy.controllerUI.trainer to javafx.fxml;
    exports org.example.mvpAcademy;
    exports org.example.mvpAcademy.controllerUI;
    exports org.example.mvpAcademy.controllerUI.trainer;
    exports org.example.mvpAcademy.controllerUI.athlete;
    exports org.example.mvpAcademy.model;
    exports org.example.mvpAcademy.view;
}