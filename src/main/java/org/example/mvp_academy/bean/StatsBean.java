package org.example.mvp_academy.bean;

import org.example.mvp_academy.model.Stat;
import org.example.mvp_academy.model.Stats;

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
        List<Stat> listStats = stats.get_list(pos);
        int make=0;
        int take=0;
        for(Stat stat : listStats){
            make+=stat.getShoot_make();
            take+=stat.getShoot_take();
        }
        String m=String.valueOf(make);
        String t= String.valueOf(take);
        return STR."\{m}/\{t}";
    }

    public String getAverageStats(String pos) {
        List<Stat> listStats = stats.get_list(pos);
        int make=0;
        int take=0;
        for(Stat stat : listStats){
            make+=stat.getShoot_make();
            take+=stat.getShoot_take();
        }
        float Averange=((float) make /take)*100;
        return new DecimalFormat("#.00").format (Averange);
    }
}
