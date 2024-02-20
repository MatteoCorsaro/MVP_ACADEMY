package org.example.mvpAcademy.bean;

import org.example.mvpAcademy.model.Stat;
import org.example.mvpAcademy.model.Stats;

import java.text.DecimalFormat;
import java.util.List;


public class StatsBean {
    private Stats stats;


    public StatsBean(Stats stats) {
        this.stats=stats;
    }
    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getStats(String pos) {
        List<Stat> listStats = stats.getList(pos);
        int make=0;
        int take=0;
        for(Stat stat : listStats){
            make+=stat.getShootMake();
            take+=stat.getShootTake();
        }
        String m=String.valueOf(make);
        String t= String.valueOf(take);
        return STR."\{m}/\{t}";
    }

    public String getAverageStats(String pos) {
        List<Stat> listStats = stats.getList(pos);
        int make=0;
        int take=0;
        for(Stat stat : listStats){
            make+=stat.getShootMake();
            take+=stat.getShootTake();
        }
        float Averange=((float) make /take)*100;
        return new DecimalFormat("#.00").format (Averange);
    }
}
