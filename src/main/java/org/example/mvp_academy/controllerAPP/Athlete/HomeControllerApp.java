package org.example.mvp_academy.controllerAPP.Athlete;

import org.example.mvp_academy.Bean.AthleteBean;
import org.example.mvp_academy.Bean.UserBean;
import org.example.mvp_academy.Dao.AthleteDAO;


public class HomeControllerApp {
    public AthleteBean ret_app_to_ui(UserBean userBean){
        //AthleteDAO athleteDAO=new AthleteDAO();
        String user=userBean.getUsername();
        return AthleteDAO.ret_Bean(user);
    }
}
