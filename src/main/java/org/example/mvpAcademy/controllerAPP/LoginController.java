package org.example.mvpAcademy.controllerAPP;


import org.example.mvpAcademy.bean.UserBean;
import org.example.mvpAcademy.dao.LoginDao;
import org.example.mvpAcademy.model.Athlete;
import org.example.mvpAcademy.model.Trainer;
import org.example.mvpAcademy.model.User;
import org.example.mvpAcademy.view.AccountType;

/**
 * Si occupa della gestione del login e della registrazione.
 */
public class LoginController {
    public boolean login(UserBean cred){
        LoginDao loginDao = new LoginDao();
        if(cred.getAccountType()== AccountType.ATHLETE){
            Athlete athlete = null;
            User user= new User(cred);
            return loginDao.checkIfExistATH(user);
        }else if(cred.getAccountType()==AccountType.TRAINER){
            Trainer trainer = null;
            User user= new User(cred);
            return loginDao.checkIfExistTRN(user);
        }
        //eccezione per dire errore utente inesistente
        return false;
    }
}
