package org.example.mvp_academy.exceptions;

import org.example.mvp_academy.other.Singleton;

import java.sql.SQLException;

public class ExceptionDB extends SQLException {

    public ExceptionDB (String e){
        Singleton.getLoginInstance().setError_message(e);
        Singleton.getLoginInstance().getViewFactory().showErrorWindow();
    }

    public ExceptionDB (Throwable cause) {
        super(cause);
    }

    public ExceptionDB (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
