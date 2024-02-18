package org.example.mvp_academy.View;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.mvp_academy.controllerUI.Athlete.AthleteControllerUI;
import org.example.mvp_academy.controllerUI.ErrorUI;
import org.example.mvp_academy.controllerUI.Trainer.TrainerControllerUI;

public class ViewFactory {
    private AccountType loginAccountType;
    /*
    ********** athlete view **************
    */
    private final ObjectProperty<AthleteMenuOption> athleteSelectedMenuItem;
    private AnchorPane HomeView;
    private AnchorPane StatsView;
    private AnchorPane BookingView;
    /*
     * ********* trainer view ***************
     */
    private final ObjectProperty<TrainerMenuOption> trainerSelectedMenuItem;
    private AnchorPane AddAthlete;
    private AnchorPane TrainerHomeView;
    private AnchorPane TrainerManageStatsView;
    private AnchorPane TrainerManageBookView;


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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Login.fxml"));
        createStage(loader);
    }

    public void showAthleteWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Athlete/Athlete.fxml"));
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
        if(HomeView==null){
            try{
                HomeView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Athlete/Home.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return HomeView;
    }
    public AnchorPane getStatsView(){
        if(StatsView==null){
            try{
                StatsView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Athlete/Stat.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return StatsView;
    }

    public AnchorPane getBookingView(){
        if(BookingView==null){
            try{
                BookingView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Athlete/Booking.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return BookingView;
    }

    public void showTrainerWindow(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/Trainer.fxml"));
        TrainerControllerUI trainerControllerUI = new TrainerControllerUI();
        loader.setController(trainerControllerUI);
        createStage(loader);

    }

    public AnchorPane getTrainerHomeView(){
        if(TrainerHomeView==null){
            try{
                TrainerHomeView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/trainerHome.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TrainerHomeView;
    }
    public AnchorPane getAddAthleteView(){
        if(AddAthlete==null){
            try{
                AddAthlete = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/TrainerAddAthlete.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return AddAthlete;
    }

    public AnchorPane getBookingManageView() {
        if(TrainerManageBookView==null){
            try{
                TrainerManageBookView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/ManageBook.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TrainerManageBookView;
    }
    public AnchorPane getStatsManageView() {
        if(TrainerManageStatsView==null){
            try{
                TrainerManageStatsView = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Trainer/ManageStats.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TrainerManageStatsView;
    }
    public ObjectProperty athleteSelectedMenuItemProperty() {
        return athleteSelectedMenuItem;
    }

    public ObjectProperty trainerSelectedMenuItemProperty() {
        return trainerSelectedMenuItem;
    }

    public void showErrorWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mvp_academy/Error.fxml"));
        ErrorUI ControllerUI = new ErrorUI();
        loader.setController(ControllerUI);
        createStage(loader);
    }
}
