package org.example.progetto.bean;

import org.example.progetto.POSITION;

import java.util.Date;

public class AthleteBean{
    /*Responsabilità di propagare la richiesta di popolare le vaire label*/

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String team;
    private POSITION position;

    public AthleteBean(String name,String surname,Date birth,String team,POSITION position){
        this.name =name;
        this.surname =surname;
        this.team =team;
        this.position =position;
        this.dateOfBirth =birth;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
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
    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }
}
