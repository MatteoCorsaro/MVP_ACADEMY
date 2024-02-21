package org.example.progetto.model;

import org.example.progetto.constant.AccountType;
import org.example.progetto.POSITION;

import java.util.Date;

public class Athlete extends User{
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String weight;
    private String height;
    private POSITION position;
    private String team;
    private String email;
    private String phone;

    public Athlete(){
        super(AccountType.ATHLETE);
        this.name =null;
        this.surname =null;
        this.dateOfBirth =null;
        this.weight =null;
        this.height =null;
        this.position =null;
        this.team =null;
        this.email=null;
        this.phone=null;
    }

    public String getName(){
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getHeight() {
        return height;
    }
    public String getWeight() {
        return weight;
    }
    public String getTeam() {
        return team;
    }
    public POSITION getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
/******Set method*******/
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPosition(POSITION position) {
        this.position = position;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
