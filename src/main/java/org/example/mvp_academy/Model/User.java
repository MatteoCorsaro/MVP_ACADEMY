package org.example.mvp_academy.Model;

import org.example.mvp_academy.Bean.UserBean;
import org.example.mvp_academy.View.AccountType;

public class User {
    private AccountType user_type;
    private String username;
    private String password;

    public User(){
        this.user_type=null;
        this.username=null;
        this.password=null;
    }
    public User(AccountType user_type){
        this.user_type=user_type;
    }
    public User(AccountType user_t, String username,String password){
        this.user_type=user_t;
        this.username=username;
        this.password=password;
    }
    public User(UserBean cred){
        this.user_type=cred.getAccountType();
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
    public AccountType getUser_type() {
        return user_type;
    }

    public void setUser_type(AccountType user_type) {
        this.user_type = user_type;
    }
}
