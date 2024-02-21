package org.example.progetto.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.progetto.Singleton;
import org.example.progetto.bean.AthleteBean;
import org.example.progetto.controllerui.trainer.AthleteCellControllerUI;

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
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
    }
}
