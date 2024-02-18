package org.example.mvp_academy.controllerAPP.Athlete;

import org.example.mvp_academy.Bean.StatsBean;
import org.example.mvp_academy.Bean.UserBean;
import org.example.mvp_academy.Dao.StatsDAO;

public class StatsControllerApp {
    public StatsBean ret_statsBean(UserBean userBean) throws Exception {
        //StatsDAO statsDAO=new StatsDAO();
        String user=userBean.getUsername();
        return StatsDAO.ret_bean(user);
    }
}
