package org.example.mvpAcademy.model;

import org.example.mvpAcademy.POS;

public class Stat {
    private POS position;
    private int shootMake;
    private int shootTake;

    public Stat(POS pos, int make, int take){
        this.position=pos;
        this.shootMake =make;
        this.shootTake =take;
    }

    public POS getPosition() {
        return position;
    }
    public void setPosition(POS position) {
        this.position = position;
    }
    public int getShootMake() {
        return shootMake;
    }
    public void setShootMake(int shootMake) {
        this.shootMake = shootMake;
    }
    public int getShootTake() {
        return shootTake;
    }
    public void setShootTake(int shootTake) {
        this.shootTake = shootTake;
    }
}
