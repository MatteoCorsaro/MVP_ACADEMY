package org.example.mvp_academy;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.mvp_academy.other.Singleton;

public class App extends Application{
    @Override
    public void start(Stage stage){
        Singleton.getLoginInstance().getViewFactory().showLoginWindow();
    }
}
