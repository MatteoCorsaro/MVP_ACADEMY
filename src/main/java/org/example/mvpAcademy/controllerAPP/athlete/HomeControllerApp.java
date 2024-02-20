package org.example.mvpAcademy.controllerAPP.athlete;

import org.example.mvpAcademy.bean.AthleteBean;
import org.example.mvpAcademy.bean.UserBean;
import org.example.mvpAcademy.dao.AthleteDAO;


public class HomeControllerApp {
    public AthleteBean retAppToUi(UserBean userBean){

        String user=userBean.getUsername();
        return AthleteDAO.retBean(user);
    }
}
