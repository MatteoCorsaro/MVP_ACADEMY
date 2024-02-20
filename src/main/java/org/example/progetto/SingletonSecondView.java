package org.example.progetto;

import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.ConnectionDB;
import org.example.progetto.view.SecondViewFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SingletonSecondView {

    private final PrintStream printerStream;
    private final BufferedReader readerStream;

    private static SingletonSecondView singleton;
    private final SecondViewFactory viewFactory;

    private final ConnectionDB daoFactory;

    private UserBean user;
    private String errorMessage;

    public SingletonSecondView() {
        this.viewFactory = new SecondViewFactory();
        this.daoFactory = new ConnectionDB();

        this.printerStream=new PrintStream(System.out);
        this.readerStream=new BufferedReader(new InputStreamReader(System.in));
    }

    public static synchronized SingletonSecondView getLoginInstance() {
        if (singleton == null){
            singleton = new SingletonSecondView();
        }
        return singleton;
    }

    public SecondViewFactory getViewFactory(){
        return  viewFactory;
    }
    public ConnectionDB getDaoFactory() {
        return daoFactory;
    }
    public BufferedReader getReaderStream() {
        return readerStream;
    }
    public PrintStream getPrinterStream() {
        return printerStream;
    }

    public UserBean getUser(){return user;}

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
