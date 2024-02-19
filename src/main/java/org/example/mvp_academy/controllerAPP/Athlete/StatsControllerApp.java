package org.example.mvp_academy.controllerAPP.Athlete;

import org.example.mvp_academy.bean.StatsBean;
import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.dao.StatsDAO;

public class StatsControllerApp {
    public StatsBean ret_statsBean(UserBean userBean) throws Exception {
        //StatsDAO statsDAO=new StatsDAO();
        String user=userBean.getUsername();
        return StatsDAO.ret_bean(user);
    }
}
