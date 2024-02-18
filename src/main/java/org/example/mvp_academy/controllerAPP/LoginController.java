package org.example.mvp_academy.controllerAPP;


import org.example.mvp_academy.Bean.UserBean;
//import org.example.mvp_academy.Dao.AthleteDAO;
import org.example.mvp_academy.Dao.LoginDao;
//import org.example.mvp_academy.Dao.TrainerDAO;
import org.example.mvp_academy.Model.Athlete;
import org.example.mvp_academy.Model.Trainer;
import org.example.mvp_academy.Model.User;
import org.example.mvp_academy.View.AccountType;

/**
 * Si occupa della gestione del login e della registrazione.
 */
public class LoginController {
    public boolean login(UserBean cred){
        LoginDao loginDao = new LoginDao();
        if(cred.getAccountType()== AccountType.ATHLETE){
            Athlete athlete=null;
            User user= new User(cred);
            return loginDao.checkIfExist_ATH(user);
        }else if(cred.getAccountType()==AccountType.TRAINER){
            Trainer trainer=null;
            User user= new User(cred);
            return loginDao.checkIfExist_TRN(user);
        }
        //eccezione per dire errore utente inesistente
        return false;
    }
}
