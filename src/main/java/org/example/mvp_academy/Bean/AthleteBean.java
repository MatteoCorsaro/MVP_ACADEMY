package org.example.mvp_academy.Bean;

import org.example.mvp_academy.other.POSITION;

import java.time.LocalDate;
import java.util.Date;

public class AthleteBean{
    /*Responsabilità di propagare la richiesta di popolare le vaire label*/

    private String Name;
    private String Surname;
    private Date Date_of_birth;
    private String Team;
    private POSITION Position;

    public AthleteBean(String name,String surname,Date birth,String team,POSITION position){
        this.Name=name;
        this.Surname=surname;
        this.Team=team;
        this.Position=position;
        this.Date_of_birth=birth;
    }
    public String getName() {
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public Date getDate_of_birth() {
        return Date_of_birth;
    }
    public String getTeam() {
        return Team;
    }
    public POSITION getPosition() {
        return Position;
    }

    public void setName(String username) {
        this.Name = username;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }
    public void setPosition(POSITION position) {
        Position = position;
    }
    public void setTeam(String team) {
        Team = team;
    }
    public void setDate_of_birth(Date date_of_birth) {
        Date_of_birth = date_of_birth;
    }
}
