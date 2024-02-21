package org.example.progetto.dao;

import org.example.progetto.bean.StatsBean;
import org.example.progetto.exception.MyException;
import org.example.progetto.model.Stat;
import org.example.progetto.model.Stats;
import org.example.progetto.POS;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StatsDAO{

    private static final String TREE_STATS ="tree_stats";
    private static final String MID_STATS ="mid_stats";

    private static final String RIGHT_CORNER ="right_corner";
    private static final String RIGHT_WING ="right_wing";
    private static final String TOP_OF_THE_KEY ="top_of_the_key";
    private static final String LEFT_WING ="left_wing";
    private static final String LEFT_CORNER ="left_corner";

    private StatsDAO() {
        throw new IllegalStateException("Utility class");
    }

    public static String getJSONFromFile(String filename){
        StringBuilder jsonText= new StringBuilder();
        try{
            BufferedReader bufferedReader= tryBuffer(filename);
            if(bufferedReader==null){
                return null;
            }

            String line;
            while((line=bufferedReader.readLine())!=null){
                jsonText.append(line).append("\n");
            }

            bufferedReader.close();
            return jsonText.toString();
        }catch(Exception e){
            MyException ex = new MyException();
            ex.exceptionDB(e);
        }
        return null;
    }
    private static BufferedReader tryBuffer(String filename){
        try{
            return new BufferedReader(new FileReader(filename));
        }catch(Exception e) {
            MyException ex = new MyException();
            ex.exceptionDB(e);
            return null;
        }
    }

    public static String getStats(String strJSON, String user, String range,String pos, String date){
        JSONObject jsonObject=new JSONObject(strJSON);
        if(range==null && pos==null && date==null){
            return jsonObject.getString(user);
        }else if(pos==null && date==null){
            JSONObject dept = jsonObject.getJSONObject(user);
            return dept.getString(range);
        }else{
            JSONObject dept = jsonObject.getJSONObject(user);
            JSONObject stat = dept.getJSONObject(range).getJSONObject(pos);
            return stat.getString(date);
        }
    }

    public static Stats getStatsByUsername(String username){
        String strJson=getJSONFromFile("C:\\Users\\Matteo\\OneDrive\\Desktop\\Progetto\\5 Code\\MVP_ACADEMY\\src\\main\\java\\data\\Stats.json");
        ReservationDao reservationDao = new ReservationDao();
        List<String> allDate = reservationDao.getAllPastDate(username);
        List<Stat> statList= new ArrayList<>();
        for(String date : allDate){
            Stat statRcMd = retStat(strJson,username, MID_STATS, RIGHT_CORNER,date);
            statList.add(statRcMd);

            Stat statRwMd = retStat(strJson,username, MID_STATS, RIGHT_WING,date);
            statList.add(statRwMd);
            Stat statKeyM = retStat(strJson,username, MID_STATS, TOP_OF_THE_KEY,date);
            statList.add(statKeyM);
            Stat statLwMd = retStat(strJson,username, MID_STATS, LEFT_WING,date);
            statList.add(statLwMd);
            Stat statLcMd = retStat(strJson,username, MID_STATS, LEFT_CORNER,date);
            statList.add(statLcMd);

            Stat statRcT = retStat(strJson,username, TREE_STATS, RIGHT_CORNER,date);
            statList.add(statRcT);
            Stat statRwT = retStat(strJson,username, TREE_STATS, RIGHT_WING,date);
            statList.add(statRwT);
            Stat statKeyT = retStat(strJson,username, TREE_STATS, TOP_OF_THE_KEY,date);
            statList.add(statKeyT);
            Stat statLwT = retStat(strJson,username, TREE_STATS, LEFT_WING,date);
            statList.add(statLwT);
            Stat statLcT = retStat(strJson,username, TREE_STATS, LEFT_CORNER,date);
            statList.add(statLcT);
        }
        return new Stats(statList);
    }

    public static Stat retStat(String json, String user, String range, String pos, String date) {
        POS position;
        switch (range) {
            case MID_STATS -> {
                switch (pos) {
                    case RIGHT_CORNER -> position = POS.MID_CORNER_RIGHT;
                    case RIGHT_WING -> position = POS.MID_WING_RIGHT;
                    case TOP_OF_THE_KEY -> position = POS.MID_TOP_OF_THE_KEY;
                    case LEFT_WING -> position = POS.MID_WING_LEFT;
                    case LEFT_CORNER -> position = POS.MID_CORNER_LEFT;
                    case null, default -> {
                        return null;
                    }
                }
            }
            case TREE_STATS -> {
                switch (pos) {
                    case RIGHT_CORNER -> position = POS.THREE_CORNER_RIGHT;
                    case RIGHT_WING -> position = POS.THREE_WING_RIGHT;
                    case TOP_OF_THE_KEY -> position = POS.THREE_TOP_OF_THE_KEY;
                    case LEFT_WING -> position = POS.THREE_WING_LEFT;
                    case LEFT_CORNER -> position = POS.THREE_CORNER_LEFT;
                    case null, default -> {
                        return null;
                    }
                }
            }
            case "free_throw" -> position = POS.FREE_THROW;
            default -> {
                return null;
            }
        }
        String statSTR=getStats(json,user,range,pos,date);
        String[] parts = statSTR.split("/");
        return new Stat(position,Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
    }

    public static StatsBean retBean(String user){
        Stats stats = getStatsByUsername(user);
        return new StatsBean(stats);
    }

}
