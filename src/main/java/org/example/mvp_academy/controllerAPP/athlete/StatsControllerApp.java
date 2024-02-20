package org.example.mvp_academy.controllerAPP.athlete;

import org.example.mvp_academy.bean.StatsBean;
import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.dao.StatsDAO;

public class StatsControllerApp {
    public StatsBean retStatsBean(UserBean userBean) throws Exception {
        String user=userBean.getUsername();
        return StatsDAO.ret_bean(user);
    }
}
