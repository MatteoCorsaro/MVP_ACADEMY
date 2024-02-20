package org.example.mvpAcademy;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage stage){
        Singleton.getLoginInstance().getViewFactory().showLoginWindow();
    }
}
