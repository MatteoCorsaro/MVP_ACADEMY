package org.example.mvp_academy.controllerAPP.athlete;

import org.example.mvp_academy.bean.AthleteBean;
import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.dao.AthleteDAO;


public class HomeControllerApp {
    public AthleteBean retAppToUi(UserBean userBean){

        String user=userBean.getUsername();
        return AthleteDAO.retBean(user);
    }
}
