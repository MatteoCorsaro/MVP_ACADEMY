package org.example.mvpAcademy.controllerAPP.athlete;

import org.example.mvpAcademy.bean.StatsBean;
import org.example.mvpAcademy.bean.UserBean;
import org.example.mvpAcademy.dao.StatsDAO;

public class StatsControllerApp {
    public StatsBean retStatsBean(UserBean userBean) throws Exception {
        String user=userBean.getUsername();
        return StatsDAO.ret_bean(user);
    }
}
