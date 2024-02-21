package org.example.progetto.controller;


import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.LoginDao;
import org.example.progetto.model.User;
import org.example.progetto.constant.AccountType;

/**
 * Si occupa della gestione del login e della registrazione.
 */
public class LoginController {
    public boolean login(UserBean cred){
        LoginDao loginDao = new LoginDao();
        if(cred.getAccountType()== AccountType.ATHLETE){
            User user= new User(cred);
            return loginDao.checkIfExistATH(user);
        }else if(cred.getAccountType()==AccountType.TRAINER){
            User user= new User(cred);
            return loginDao.checkIfExistTRN(user);
        }
        return false;
    }
}
