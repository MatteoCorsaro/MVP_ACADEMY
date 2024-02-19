package org.example.mvp_academy.controllerUI;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.mvp_academy.bean.UserBean;
import org.example.mvp_academy.view.AccountType;
import org.example.mvp_academy.controllerAPP.LoginController;
import org.example.mvp_academy.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginControllerUI implements Initializable {
    public ChoiceBox<AccountType>account_selector;
    public TextField Username_field;
    public TextField Password_field;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        account_selector.setItems(FXCollections.observableArrayList(AccountType.ATHLETE, AccountType.TRAINER));
        account_selector.setValue(Singleton.getLoginInstance().getViewFactory().getLoginAccountType());
        account_selector.valueProperty().addListener(observable -> Singleton.getLoginInstance().getViewFactory().setLoginAccountType(account_selector.getValue()));

        login_btn.setOnAction(event-> onLogin());
    }

    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        //Singleton.getLoginInstance().getViewFactory().closeStage(stage);
        UserBean  cred = new UserBean(Username_field.getText(),Password_field.getText());
        Singleton.getLoginInstance().setUser(cred);
        if(Singleton.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.ATHLETE){
            cred.setAccountType(AccountType.ATHLETE);
            if(check_log(cred)) {
                Singleton.getLoginInstance().getViewFactory().closeStage(stage);
                Singleton.getLoginInstance().getViewFactory().showAthleteWindow();
            }else{
                Password_field.setText("");
                Password_field.setText("");
                error_lbl.setText("INCORRECT CREDENTIALS.");
            }

        }else if(Singleton.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.TRAINER){
            cred.setAccountType(AccountType.TRAINER);
            if(check_log(cred)){
                Singleton.getLoginInstance().getViewFactory().closeStage(stage);
                Singleton.getLoginInstance().getViewFactory().showTrainerWindow();
            }else{
                Username_field.setText("");
                Password_field.setText("");
                error_lbl.setText("INCORRECT CREDENTIALS.");
            }

        }else{
            Username_field.setText("");
            Password_field.setText("");
            error_lbl.setText("ERROR 1: ACCOUNT TYPE NOT SELECTED.");
        }
    }
    private boolean check_log(UserBean cred){
        LoginController loginController=new LoginController();
        return loginController.login(cred);
    }
}
