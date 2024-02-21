package org.example.progetto.controller.athlete;

import org.example.progetto.bean.StatsBean;
import org.example.progetto.bean.UserBean;
import org.example.progetto.dao.StatsDAO;

public class StatsControllerApp {
    public StatsBean retStatsBean(UserBean userBean) throws Exception {
        String user=userBean.getUsername();
        return StatsDAO.ret_bean(user);
    }
}
