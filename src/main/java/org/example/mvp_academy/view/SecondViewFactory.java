package org.example.mvp_academy.view;

import org.example.mvp_academy.secondControllerUI.LoginControllerUI;
import org.example.mvp_academy.secondControllerUI.athlete.AthleteAccountControllerUI;
import org.example.mvp_academy.secondControllerUI.athlete.AthleteBookControllerUI;
import org.example.mvp_academy.secondControllerUI.athlete.AthleteMenuControllerUI;
import org.example.mvp_academy.secondControllerUI.athlete.AthleteStatsControllerUI;
import org.example.mvp_academy.secondControllerUI.trainer.*;

public class SecondViewFactory {
    private AccountType loginAccountType;

    public SecondViewFactory(){
        this.loginAccountType= AccountType.ATHLETE;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void showLoginWindow(){
        LoginControllerUI secondLog=new LoginControllerUI();
        secondLog.start();
    }

    /*--------- MENU---------*/
    public void showAthleteMenu() {
        AthleteMenuControllerUI secondAthleteMenu=new AthleteMenuControllerUI();
        secondAthleteMenu.start();
    }

    public void showTrainerMenu() {
        TrainerMenuControllerUI secondTrainerMenu=new TrainerMenuControllerUI();
        secondTrainerMenu.start();
    }

    /*--------- ATHLETE SCENE---------*/
    public void showAthleteAccount() {
        AthleteAccountControllerUI secondController =new AthleteAccountControllerUI();
        secondController.start();
    }
    public void showAthleteBook() {
        AthleteBookControllerUI secondController = new AthleteBookControllerUI();
        secondController.start();
    }

    public void showAthleteStats() {
        AthleteStatsControllerUI secondController = new AthleteStatsControllerUI();
        secondController.start();
    }

    /*--------- TRAINER SCENE---------*/
    public void showTrainerAccount() {
        TrainerHomeControllerUI secondController = new TrainerHomeControllerUI();
        secondController.start();
    }

    public void showTrainerBook() {
        TrainerManageBookControllerUI secondController = new TrainerManageBookControllerUI();
        secondController.start();
    }

    public void showTrainerStats() {
        TrainerManageStatsControllerUI secondController = new TrainerManageStatsControllerUI();
        secondController.start();
    }
    public void showTrainerAddAthlete() {
        TrainerAddAthleteControllerUI secondController = new TrainerAddAthleteControllerUI();
        secondController.start();
    }

    /*-----ON LOGOUT---------------------*/
    public void logout() {
    }
}
