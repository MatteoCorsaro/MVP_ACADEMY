package org.example.mvp_academy.Dao;

import org.example.mvp_academy.Bean.StatsBean;
import org.example.mvp_academy.Model.Stat;
import org.example.mvp_academy.Model.Stats;
import org.example.mvp_academy.other.POS;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StatsDAO{

    public static String getJSONFromFile(String filename){
        StringBuilder jsonText= new StringBuilder();
        try{
            BufferedReader bufferedReader= new BufferedReader(new FileReader(filename));

            String line;
            while((line=bufferedReader.readLine())!=null){
                jsonText.append(line).append("\n");
            }

            bufferedReader.close();
            return jsonText.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
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

    public static Stats getStatsByUsername(String username) throws Exception {
        String strJson=getJSONFromFile("C:\\Users\\Matteo\\OneDrive\\Desktop\\Progetto\\5 Code\\MVP_ACADEMY\\src\\main\\java\\data\\Stats.json");
        //System.out.println("Sto QUIIII");
        ReservationDao reservationDao = new ReservationDao();
        List<String> allDate = reservationDao.getAllPastDate(username);
        List<Stat> statList= new ArrayList<>();
        for(String date : allDate){
            Stat statRcMd = ret_stat(strJson,username,"mid_stats","right_corner",date);
            statList.add(statRcMd);

            Stat statRwMd = ret_stat(strJson,username,"mid_stats","right_wing",date);
            statList.add(statRwMd);
            Stat statKeyM = ret_stat(strJson,username,"mid_stats","top_of_the_key",date);
            statList.add(statKeyM);
            Stat statLwMd = ret_stat(strJson,username,"mid_stats","left_wing",date);
            statList.add(statLwMd);
            Stat statLcMd = ret_stat(strJson,username,"mid_stats","left_corner",date);
            statList.add(statLcMd);

            Stat statRcT = ret_stat(strJson,username,"tree_stats","right_corner",date);
            statList.add(statRcT);
            Stat statRwT = ret_stat(strJson,username,"tree_stats","right_wing",date);
            statList.add(statRwT);
            Stat statKeyT = ret_stat(strJson,username,"tree_stats","top_of_the_key",date);
            statList.add(statKeyT);
            Stat statLwT = ret_stat(strJson,username,"tree_stats","left_wing",date);
            statList.add(statLwT);
            Stat statLcT = ret_stat(strJson,username,"tree_stats","left_corner",date);
            statList.add(statLcT);

            /*Stat statFT = ret_stat(strJson,username,"free_throw",null,date);
            statList.add(statFT);*/
        }
        return new Stats(statList);
    }

    public static Stat ret_stat(String json, String user, String range, String pos, String date) {
        POS position;
        switch (range) {
            case "mid_stats" -> {
                switch (pos) {
                    case "right_corner" -> position = POS.MID_CORNER_RIGHT;
                    case "right_wing" -> position = POS.MID_WING_RIGHT;
                    case "top_of_the_key" -> position = POS.MID_TOP_OF_THE_KEY;
                    case "left_wing" -> position = POS.MID_WING_LEFT;
                    case "left_corner" -> position = POS.MID_CORNER_LEFT;
                    case null, default -> {
                        return null;
                    }
                }
            }
            case "tree_stats" -> {
                switch (pos) {
                    case "right_corner" -> position = POS.THREE_CORNER_RIGHT;
                    case "right_wing" -> position = POS.THREE_WING_RIGHT;
                    case "top_of_the_key" -> position = POS.THREE_TOP_OF_THE_KEY;
                    case "left_wing" -> position = POS.THREE_WING_LEFT;
                    case "left_corner" -> position = POS.THREE_CORNER_LEFT;
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
        String StatSTR=getStats(json,user,range,pos,date);
        String[] parts = StatSTR.split("/");
        return new Stat(position,Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
    }

    public static StatsBean ret_bean(String user) throws Exception {
        Stats stats = getStatsByUsername(user);
        return new StatsBean(stats);
    }

}
