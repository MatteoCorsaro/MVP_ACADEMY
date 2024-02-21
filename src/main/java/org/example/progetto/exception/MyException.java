package org.example.progetto.exception;

import org.example.progetto.Singleton;

import java.util.logging.Logger;

public class MyException {

    private static MyException instance;

    private String userInterface;
    Logger logger = Logger.getLogger(getClass().getName());

    public static MyException getInstance() {
        if (instance == null) {
            instance = new MyException();
        }
        return instance;
    }

    public void alreadyExist() {
        if(userInterface=="CLI"){
            logger.info("ESISTE GIA' UNA PRENOTAZIONE CON QUESTA DATA E QUESTO ORARIO");
        }else{
            Singleton.getLoginInstance().setErrorMessage("ESISTE GIA' UNA PRENOTAZIONE CON QUESTA DATA E QUESTO ORARIO");
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }

    }

    public void pastDay() {
        if(userInterface=="CLI"){
            logger.info("NON PUOI PRENOTARE IN UN GIORNO PASSATO");
        }else{
            Singleton.getLoginInstance().setErrorMessage("NON PUOI PRENOTARE IN UN GIORNO PASSATO");
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }

    public void exceptionDB(Exception e) {
        if(userInterface=="CLI"){
            logger.info(e.getMessage());
        }else {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }

    }

    public void setUserInterface(String userInterface) {
        this.userInterface = userInterface;
    }
}
