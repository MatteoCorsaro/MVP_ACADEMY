package org.example.mvp_academy.Model;

import org.example.mvp_academy.View.AccountType;
import org.example.mvp_academy.other.POSITION;

import java.util.Date;

public class Athlete extends User{
    private String Name;
    private String  Surname;
    private Date Date_of_birth;
    private String Weight;
    private String Height;
    private POSITION Position;
    private String Team;
    private String email;
    private String phone;

    public Athlete(){
        super(AccountType.ATHLETE);
        this.Name=null;
        this.Surname=null;
        this.Date_of_birth=null;
        this.Weight=null;
        this.Height=null;
        this.Position=null;
        this.Team=null;
        this.email=null;
        this.phone=null;
    }

    public Athlete(String name, String surname,String weight, String height , Date date_of_birth, POSITION position, String team, String email, String phone){
        super(AccountType.ATHLETE);
        this.Name=name;
        this.Surname=surname;
        this.Date_of_birth=date_of_birth;
        this.Weight=weight;
        this.Height=height;
        this.Position=position;
        this.Team=team;
        this.email=email;
        this.phone=phone;

    }

    public String getName(){
        return Name;
    }
    public String getSurname() {
        return Surname;
    }
    public Date getDate_of_birth() {
        return Date_of_birth;
    }
    public String getHeight() {
        return Height;
    }
    public String getWeight() {
        return Weight;
    }
    public String getTeam() {
        return Team;
    }
    public POSITION getPosition() {
        return Position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
/******Set method*******/
    public void setName(String name) {
        Name = name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void setPosition(POSITION position) {
        Position = position;
    }
    public void setHeight(String height) {
        Height = height;
    }
    public void setTeam(String team) {
        Team = team;
    }
    public void setWeight(String weight) {
        Weight = weight;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDate_of_birth(Date date_of_birth) {
        Date_of_birth = date_of_birth;
    }
}
