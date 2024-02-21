package org.example.progetto.controllerui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.progetto.bean.UserBean;
import org.example.progetto.constant.AccountType;
import org.example.progetto.controller.LoginController;
import org.example.progetto.Singleton;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginControllerUI implements Initializable{

    @FXML
    private ChoiceBox<AccountType> accountSelector;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Label errorLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        accountSelector.getItems().addAll(FXCollections.observableArrayList(AccountType.ATHLETE, AccountType.TRAINER));
        accountSelector.setValue(Singleton.getLoginInstance().getViewFactory().getLoginAccountType());
        accountSelector.valueProperty().addListener(observable -> Singleton.getLoginInstance().getViewFactory().setLoginAccountType(accountSelector.getValue()));

        loginBtn.setOnAction(event-> onLogin());
    }

    public void onLogin(){
        Stage stage = (Stage) errorLbl.getScene().getWindow();
        UserBean  cred = new UserBean(usernameField.getText(), passwordField.getText());

        Singleton.getLoginInstance().setUser(cred);
        if(Singleton.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.ATHLETE){
            cred.setAccountType(AccountType.ATHLETE);
            if(checkLog(cred)) {
                Singleton.getLoginInstance().getViewFactory().closeStage(stage);
                Singleton.getLoginInstance().getViewFactory().showAthleteWindow();
            }else{
                usernameField.setText("");
                passwordField.setText("");
                errorLbl.setText("INCORRECT CREDENTIALS.");
            }

        }else if(Singleton.getLoginInstance().getViewFactory().getLoginAccountType()== AccountType.TRAINER){
            cred.setAccountType(AccountType.TRAINER);
            if(checkLog(cred)){
                Singleton.getLoginInstance().getViewFactory().closeStage(stage);
                Singleton.getLoginInstance().getViewFactory().showTrainerWindow();
            }else{
                usernameField.setText("");
                passwordField.setText("");
                errorLbl.setText("INCORRECT CREDENTIALS.");
            }

        }else{
            usernameField.setText("");
            passwordField.setText("");
            errorLbl.setText("ERROR 1: ACCOUNT TYPE NOT SELECTED.");
        }
    }
    private boolean checkLog(UserBean cred){
        LoginController loginController=new LoginController();
        return loginController.login(cred);
    }
}
