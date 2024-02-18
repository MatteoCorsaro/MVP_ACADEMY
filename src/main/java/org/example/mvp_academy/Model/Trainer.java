package org.example.mvp_academy.Model;

import org.example.mvp_academy.View.AccountType;

public class Trainer extends User{
    private String Name;
    private String Surname;
    private String email;
    private String phone;

    public Trainer(String name, String surname, String email, String phone){
        super(AccountType.TRAINER);
        this.Name=name;
        this.Surname=surname;
        this.email=email;
        this.phone=phone;
    }
    /****Getter Methods****/
    public String getName() {return Name;}
    public String getSurname() {return Surname;}
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    /****Setter Methods****/
    public void setName(String name) {
        Name = name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
