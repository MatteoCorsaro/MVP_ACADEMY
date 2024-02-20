package org.example.progetto.model;

import org.example.progetto.view.AccountType;

public class Trainer extends User{
    private String name;
    private String surname;
    private String email;
    private String phone;

    public Trainer(String name, String surname, String email, String phone){
        super(AccountType.TRAINER);
        this.name =name;
        this.surname =surname;
        this.email=email;
        this.phone=phone;
    }

    public Trainer() {
        super(AccountType.TRAINER);
        this.name =null;
        this.surname =null;
        this.email=null;
        this.phone=null;
    }

    /****Getter Methods****/
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    /****Setter Methods****/
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
