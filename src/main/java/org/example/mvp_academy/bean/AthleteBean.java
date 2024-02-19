package org.example.mvp_academy.bean;

import org.example.mvp_academy.POSITION;

import java.util.Date;

public class AthleteBean{
    /*Responsabilità di propagare la richiesta di popolare le vaire label*/

    private String name;
    private String surname;
    private Date date_of_birth;
    private String team;
    private POSITION position;

    public AthleteBean(String name,String surname,Date birth,String team,POSITION position){
        this.name =name;
        this.surname =surname;
        this.team =team;
        this.position =position;
        this.date_of_birth =birth;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Date getDateOfBirth() {
        return date_of_birth;
    }
    public String getTeam() {
        return team;
    }
    public POSITION getPosition() {
        return position;
    }

    public void setName(String username) {
        this.name = username;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPosition(POSITION position) {
        this.position = position;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
