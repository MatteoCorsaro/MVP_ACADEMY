package org.example.mvp_academy.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.mvp_academy.bean.AthleteBean;
import org.example.mvp_academy.controllerUI.Trainer.AthleteCellControllerUI;

public class AthleteCellFactory extends ListCell<AthleteBean> {
    @Override
    protected void updateItem(AthleteBean athlete,boolean empty){
        super.updateItem(athlete,empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/AthleteCell"));
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
