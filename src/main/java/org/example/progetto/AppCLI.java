package org.example.progetto;

public class AppCLI {
    public static void main(String[] args) {
        SingletonSecondView.getLoginInstance().getViewFactory().showLoginWindow();
    }
}
