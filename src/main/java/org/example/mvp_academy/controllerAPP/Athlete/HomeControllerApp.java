package org.example.mvp_academy.controllerAPP.Athlete;

import org.example.mvp_academy.bean.AthleteBean;
import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.dao.AthleteDAO;


public class HomeControllerApp {
    public AthleteBean ret_app_to_ui(UserBean userBean){
        //AthleteDAO athleteDAO=new AthleteDAO();
        String user=userBean.getUsername();
        return AthleteDAO.ret_Bean(user);
    }
}
