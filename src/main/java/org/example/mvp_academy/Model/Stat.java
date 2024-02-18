package org.example.mvp_academy.Model;

import org.example.mvp_academy.other.POS;

public class Stat {
    private POS position;
    private int shoot_make;
    private int shoot_take;

    public Stat(POS pos, int make, int take){
        this.position=pos;
        this.shoot_make=make;
        this.shoot_take=take;
    }

    public POS getPosition() {
        return position;
    }
    public void setPosition(POS position) {
        this.position = position;
    }
    public int getShoot_make() {
        return shoot_make;
    }
    public void setShoot_make(int shoot_make) {
        this.shoot_make = shoot_make;
    }
    public int getShoot_take() {
        return shoot_take;
    }
    public void setShoot_take(int shoot_take) {
        this.shoot_take = shoot_take;
    }
}
