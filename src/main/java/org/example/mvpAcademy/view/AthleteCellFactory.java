package org.example.mvpAcademy.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.mvpAcademy.bean.AthleteBean;
import org.example.mvpAcademy.controllerUI.trainer.AthleteCellControllerUI;

public class AthleteCellFactory extends ListCell<AthleteBean> {
    @Override
    protected void updateItem(AthleteBean athlete,boolean empty){
        super.updateItem(athlete,empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvpAcademy/Trainer/AthleteCell"));
            AthleteCellControllerUI controllerUI = new AthleteCellControllerUI(athlete);
            loader.setController(controllerUI);
            setText(null);
            try{
                setGraphic(loader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
