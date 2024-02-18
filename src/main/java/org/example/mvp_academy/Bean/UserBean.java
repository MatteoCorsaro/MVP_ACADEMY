package org.example.mvp_academy.Bean;


import org.example.mvp_academy.Dao.AthleteDAO;
import org.example.mvp_academy.View.AccountType;

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

    public AthleteBean ret_athlete() {
        //RESTITUISCE L'ATLETA ASSOCIATO ALL'USER
        AthleteBean athleteBean=AthleteDAO.ret_Bean(this.username);

        return athleteBean;
    }
}
