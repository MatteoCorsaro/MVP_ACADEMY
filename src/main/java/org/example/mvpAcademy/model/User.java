package org.example.mvpAcademy.model;

import org.example.mvpAcademy.bean.UserBean;
import org.example.mvpAcademy.view.AccountType;

public class User {
    private AccountType accountType;
    private String username;
    private String password;

    public User(){
        this.accountType =null;
        this.username=null;
        this.password=null;
    }
    public User(AccountType user_type){
        this.accountType =user_type;
    }
    public User(AccountType user_t, String username,String password){
        this.accountType =user_t;
        this.username=username;
        this.password=password;
    }
    public User(UserBean cred){
        this.accountType =cred.getAccountType();
        this.username=cred.getUsername();
        this.password=cred.getPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
