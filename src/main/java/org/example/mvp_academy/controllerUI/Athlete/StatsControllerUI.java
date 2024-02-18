package org.example.mvp_academy.controllerUI.Athlete;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.mvp_academy.Bean.StatsBean;
import org.example.mvp_academy.controllerAPP.Athlete.StatsControllerApp;
import org.example.mvp_academy.other.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class StatsControllerUI implements Initializable {
    public Text RcMd;
    public Text RcMdp;
    public Text RcTp;
    public Text RcT;
    public Text RwMd;
    public Text RwMdp;
    public Text RwT;
    public Text RwTp;
    public Text KeyM;
    public Text KeyMp;
    public Text KeyT;
    public Text KeyTp;
    public Text LwMd;
    public Text LwMdp;
    public Text LwT;
    public Text LwTp;
    public Text LcMd;
    public Text LcMdp;
    public Text LcT;
    public Text LcTp;
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
            statsBean = controllerApp.ret_statsBean(Singleton.getLoginInstance().getUser());
        } catch (Exception e) {
            Singleton.getLoginInstance().setError_message(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }

        if (statsBean != null) {
            RcMd.setText(statsBean.getStats("Mid_Corner_right"));
            RwMd.setText(statsBean.getStats("Mid_Wing_right"));
            LcMd.setText(statsBean.getStats("Mid_Corner_left"));
            LwMd.setText(statsBean.getStats("Mid_wing_left"));
            KeyM.setText(statsBean.getStats("Mid_top_of_the_Key"));

            RwT.setText(statsBean.getStats("Three_Wing_right"));
            LwT.setText(statsBean.getStats("Three_wing_left"));
            KeyT.setText(statsBean.getStats("Three_top_of_the_Key"));
            LcT.setText(statsBean.getStats("Three_Corner_left"));
            RcT.setText(statsBean.getStats("Three_Corner_right"));

            RcMdp.setText(STR."\{statsBean.getAverageStats("Mid_Corner_right")}%");
            RwMdp.setText(STR."\{statsBean.getAverageStats("Mid_Wing_right")}%");
            LcMdp.setText(STR."\{statsBean.getAverageStats("Mid_Corner_left")}%");
            LwMdp.setText(STR."\{statsBean.getAverageStats("Mid_wing_left")}%");
            KeyMp.setText(STR."\{statsBean.getAverageStats("Mid_top_of_the_Key")}%");

            RwTp.setText(STR."\{statsBean.getAverageStats("Three_Wing_right")}%");
            LwTp.setText(STR."\{statsBean.getAverageStats("Three_wing_left")}%");
            KeyTp.setText(STR."\{statsBean.getAverageStats("Three_top_of_the_Key")}%");
            LcTp.setText(STR."\{statsBean.getAverageStats("Three_Corner_left")}%");
            RcTp.setText(STR."\{statsBean.getAverageStats("Three_Corner_right")}%");
        }else {
            Singleton.getLoginInstance().setError_message("ERROR STATS BEAN");
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
    }
}
