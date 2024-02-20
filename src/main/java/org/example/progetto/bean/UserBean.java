package org.example.progetto.bean;


import org.example.progetto.dao.AthleteDAO;
import org.example.progetto.view.AccountType;

public class UserBean {
    private final String username;
    private final String password;

    private AccountType role = null;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setAccountType(AccountType role){
        this.role=role;
    }
    public AccountType getAccountType() {
        return this.role;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public AthleteBean retAthlete() {
        //RESTITUISCE L'ATLETA ASSOCIATO ALL'USER
        return AthleteDAO.retBean(this.username);
    }
}
