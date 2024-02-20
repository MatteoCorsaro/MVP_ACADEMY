package org.example.progetto.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.progetto.Singleton;
import org.example.progetto.controllerUI.athlete.AthleteControllerUI;
import org.example.progetto.controllerUI.ErrorUI;
import org.example.progetto.controllerUI.trainer.TrainerControllerUI;

import java.util.Objects;

public class ViewFactory {
    private AccountType loginAccountType;
    /*
    ********** athlete view **************
    */
    private final ObjectProperty<AthleteMenuOption> athleteSelectedMenuItem;
    private AnchorPane homeView;
    private AnchorPane statsView;
    private AnchorPane bookingView;
    /*
     * ********* trainer view ***************
     */
    private final ObjectProperty<TrainerMenuOption> trainerSelectedMenuItem;
    private AnchorPane addAthlete;
    private AnchorPane trainerHomeView;
    private AnchorPane trainerManageStatsView;
    private AnchorPane trainerManageBookView;


    public ViewFactory(){
        this.loginAccountType= AccountType.ATHLETE;
        this.athleteSelectedMenuItem= new SimpleObjectProperty("");
        this.trainerSelectedMenuItem= new SimpleObjectProperty("");
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Login.fxml")));
        createStage(loader);
    }

    public void showAthleteWindow(){
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Athlete/Athlete.fxml")));
        AthleteControllerUI athleteControllerUI = new AthleteControllerUI();
        loader.setController(athleteControllerUI);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e) {
            e.printStackTrace();
            Singleton.getLoginInstance().setErrorMessage(e.getMessage());
            Singleton.getLoginInstance().getViewFactory().showErrorWindow();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/mvp_academy/Images/logoMVP.png"))));
        stage.setResizable(false);
        stage.setTitle("MVP_ACADEMY");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
    public AnchorPane getHomeView(){
        if(homeView ==null){
            try{
                homeView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Athlete/Home.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return homeView;
    }
    public AnchorPane getStatsView(){
        if(statsView ==null){
            try{
                statsView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Athlete/Stat.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return statsView;
    }

    public AnchorPane getBookingView(){
        if(bookingView ==null){
            try{
                bookingView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Athlete/Booking.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return bookingView;
    }

    public void showTrainerWindow(){

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Trainer/Trainer.fxml")));
        TrainerControllerUI trainerControllerUI = new TrainerControllerUI();
        loader.setController(trainerControllerUI);
        createStage(loader);

    }

    public AnchorPane getTrainerHomeView(){
        if(trainerHomeView ==null){
            try{
                trainerHomeView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Trainer/trainerHome.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return trainerHomeView;
    }
    public AnchorPane getAddAthleteView(){
        if(addAthlete ==null){
            try{
                addAthlete = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Trainer/TrainerAddAthlete.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return addAthlete;
    }

    public AnchorPane getBookingManageView() {
        if(trainerManageBookView ==null){
            try{
                trainerManageBookView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Trainer/ManageBook.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return trainerManageBookView;
    }
    public AnchorPane getStatsManageView() {
        if(trainerManageStatsView ==null){
            try{
                trainerManageStatsView = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Trainer/ManageStats.fxml"))).load();
            } catch (Exception e) {
                Singleton.getLoginInstance().setErrorMessage(e.getMessage());
                Singleton.getLoginInstance().getViewFactory().showErrorWindow();
            }
        }
        return trainerManageStatsView;
    }
    public ObjectProperty athleteSelectedMenuItemProperty() {
        return athleteSelectedMenuItem;
    }

    public ObjectProperty trainerSelectedMenuItemProperty() {
        return trainerSelectedMenuItem;
    }

    public void showErrorWindow(){
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/org/example/mvp_academy/Error.fxml")));
        new ErrorUI();
        createStage(loader);
    }
}
