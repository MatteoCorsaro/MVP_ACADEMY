package org.example.progetto.controllerAPP.athlete;

import org.example.progetto.bean.AthleteBean;
import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.AthleteDAO;


public class HomeControllerApp {
    public AthleteBean retAppToUi(UserBean userBean){

        String user=userBean.getUsername();
        return AthleteDAO.retBean(user);
    }
}
