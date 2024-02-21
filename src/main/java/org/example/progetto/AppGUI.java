package org.example.progetto;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Singleton.getLoginInstance().getViewFactory().showLoginWindow();
    }
}
