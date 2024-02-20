package org.example.mvp_academy.controllerUI.athlete;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.mvp_academy.bean.StatsBean;
import org.example.mvp_academy.controllerAPP.athlete.StatsControllerApp;
import org.example.mvp_academy.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class StatsControllerUI implements Initializable {
    @FXML
    private Text rcMd;
    @FXML
    private Text rcMdp;
    @FXML
    private Text rcTp;
    @FXML
    private Text rcT;
    @FXML
    private Text rwMd;
    @FXML
    private Text rwMdp;
    @FXML
    private Text rwT;
    @FXML
    private Text rwTp;
    @FXML
    private Text keyM;
    @FXML
    private Text keyMp;
    @FXML
    private Text keyT;
    @FXML
    private Text keyTp;
    @FXML
    private Text lwMd;
    @FXML
    private Text lwMdp;
    @FXML
    private Text lwT;
    @FXML
    private Text lwTp;
    @FXML
    private Text lcMd;
    @FXML
    private Text lcMdp;
    @FXML
    private Text lcT;
    @FXML
    private Text lcTp;
/*

* R=right
* L=left
* Md=mid
* T=Three
* c=corner
* w=wing
* key=top of the key
* p=%
*
* */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StatsControllerApp controllerApp=new StatsControllerApp();
        StatsBean statsBean = null;
        try {
            statsBean = controllerApp.retStatsBean(Singleton.getLoginInstance().getUser());
        } catch (Exception e) {
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }

        if (statsBean != null) {
            rcMd.setText(statsBean.getStats("Mid_Corner_right"));
            rwMd.setText(statsBean.getStats("Mid_Wing_right"));
            lcMd.setText(statsBean.getStats("Mid_Corner_left"));
            lwMd.setText(statsBean.getStats("Mid_wing_left"));
            keyM.setText(statsBean.getStats("Mid_top_of_the_Key"));

            rwT.setText(statsBean.getStats("Three_Wing_right"));
            lwT.setText(statsBean.getStats("Three_wing_left"));
            keyT.setText(statsBean.getStats("Three_top_of_the_Key"));
            lcT.setText(statsBean.getStats("Three_Corner_left"));
            rcT.setText(statsBean.getStats("Three_Corner_right"));

            rcMdp.setText(STR."\{statsBean.getAverageStats("Mid_Corner_right")}%");
            rwMdp.setText(STR."\{statsBean.getAverageStats("Mid_Wing_right")}%");
            lcMdp.setText(STR."\{statsBean.getAverageStats("Mid_Corner_left")}%");
            lwMdp.setText(STR."\{statsBean.getAverageStats("Mid_wing_left")}%");
            keyMp.setText(STR."\{statsBean.getAverageStats("Mid_top_of_the_Key")}%");

            rwTp.setText(STR."\{statsBean.getAverageStats("Three_Wing_right")}%");
            lwTp.setText(STR."\{statsBean.getAverageStats("Three_wing_left")}%");
            keyTp.setText(STR."\{statsBean.getAverageStats("Three_top_of_the_Key")}%");
            lcTp.setText(STR."\{statsBean.getAverageStats("Three_Corner_left")}%");
            rcTp.setText(STR."\{statsBean.getAverageStats("Three_Corner_right")}%");
        }else {
            Singleton.getLoginInstance().setErrorMessage("ERROR STATS BEAN");
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }
}
