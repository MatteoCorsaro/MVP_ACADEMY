package org.example.mvp_academy.controllerAPP;


import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.dao.LoginDao;
import org.example.mvp_academy.model.Athlete;
import org.example.mvp_academy.model.Trainer;
import org.example.mvp_academy.model.User;
import org.example.mvp_academy.view.AccountType;

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
