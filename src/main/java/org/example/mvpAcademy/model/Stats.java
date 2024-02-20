package org.example.mvpAcademy.model;

import org.example.mvpAcademy.POS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Model relativo alle liste di statistiche
 */
public class Stats{
    protected List<Stat> listMidCornerLeftStats;
    protected List<Stat> listMidWingLeftStats;
    protected List<Stat> listMidTopOfTheKeyStats;
    protected List<Stat> listMidWingRightStats;
    protected List<Stat> listMidCornerRightStats;

    protected List<Stat> listThreeCornerLeftStats;
    protected List<Stat> listThreeWingLeftStats;
    protected List<Stat> listThreeTopOfTheKeyStats;
    protected List<Stat> listThreeWingRightStats;
    protected List<Stat> listThreeCornerRightStats;

    protected List<Stat> listFreeTrowStats;
    protected List<Stat> listStats;

    public Stats(){
        this.listStats=new ArrayList<>();

        this.listFreeTrowStats=new ArrayList<>();

        this.listThreeCornerRightStats = new ArrayList<>();
        this.listThreeCornerLeftStats = new ArrayList<>();
        this.listMidCornerLeftStats = new ArrayList<>();
        this.listMidWingLeftStats = new ArrayList<>();
        this.listMidTopOfTheKeyStats = new ArrayList<>();
        this.listMidWingRightStats = new ArrayList<>();
        this.listMidCornerRightStats = new ArrayList<>();
        this.listThreeWingLeftStats = new ArrayList<>();
        this.listThreeTopOfTheKeyStats = new ArrayList<>();
        this.listThreeWingRightStats = new ArrayList<>();
    }
    public Stats(List<Stat> stats){
        this.listStats=stats;
        this.listThreeCornerRightStats = new ArrayList<>();
        this.listThreeCornerLeftStats = new ArrayList<>();
        this.listMidCornerLeftStats = new ArrayList<>();
        this.listMidWingLeftStats = new ArrayList<>();
        this.listMidTopOfTheKeyStats = new ArrayList<>();
        this.listMidWingRightStats = new ArrayList<>();
        this.listMidCornerRightStats = new ArrayList<>();
        this.listThreeWingLeftStats = new ArrayList<>();
        this.listThreeTopOfTheKeyStats = new ArrayList<>();
        this.listThreeWingRightStats = new ArrayList<>();

        for(Stat stat: stats){
            populateList(stat);
        }
    }

    public List<Stat> getListStats() {
        return listStats;
    }
    public void setListStats(List<Stat> listStats) {
        this.listStats = listStats;
    }

    public void addStat(Stat stat) {
        listStats.add(stat);

        populateList(stat);
    }
    public void populateList(Stat stat){
        switch (stat.getPosition()){
            case FREE_THROW -> listFreeTrowStats.add(stat);

            case MID_CORNER_LEFT -> listMidCornerLeftStats.add(stat);
            case MID_WING_LEFT -> listMidWingLeftStats.add(stat);
            case MID_TOP_OF_THE_KEY -> listMidTopOfTheKeyStats.add(stat);
            case MID_WING_RIGHT -> listMidWingRightStats.add(stat);
            case MID_CORNER_RIGHT -> listMidCornerRightStats.add(stat);

            case THREE_CORNER_LEFT -> listThreeCornerLeftStats.add(stat);
            case THREE_WING_LEFT -> listThreeWingLeftStats.add(stat);
            case THREE_TOP_OF_THE_KEY -> listThreeTopOfTheKeyStats.add(stat);
            case THREE_WING_RIGHT -> listThreeWingRightStats.add(stat);
            case THREE_CORNER_RIGHT -> listThreeCornerRightStats.add(stat);
        }
    }


    public List<Stat> getList(String pos){
        switch (POS.fromString(pos)){

            case FREE_THROW ->  {
                return listFreeTrowStats;
            }

            case MID_CORNER_LEFT -> {
                return listMidCornerLeftStats;
            }
            case MID_WING_LEFT ->  {
                return listMidWingLeftStats;
            }
            case MID_TOP_OF_THE_KEY ->  {
                return listMidTopOfTheKeyStats;
            }
            case MID_WING_RIGHT ->  {
                return listMidWingRightStats;
            }
            case MID_CORNER_RIGHT ->  {
                return listMidCornerRightStats;
            }

            case THREE_CORNER_LEFT ->  {
                return listThreeCornerLeftStats;
            }
            case THREE_WING_LEFT ->  {
                return listThreeWingLeftStats;
            }
            case THREE_TOP_OF_THE_KEY -> {
                return listThreeTopOfTheKeyStats;
            }
            case THREE_WING_RIGHT ->  {
                return listThreeWingRightStats;
            }
            case THREE_CORNER_RIGHT -> {
                return listThreeCornerRightStats;
            }
        }
        return Collections.emptyList();
    }
}


