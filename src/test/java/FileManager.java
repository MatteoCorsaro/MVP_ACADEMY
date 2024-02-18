import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONObject;

public class FileManager {
        public static String getJSONFromFile(String filename){
            StringBuilder jsonText= new StringBuilder();
            try{
                BufferedReader bufferedReader= new BufferedReader(new FileReader(filename));

                String line;
                while((line=bufferedReader.readLine())!=null){
                    jsonText.append(line).append("\n");
                }

                bufferedReader.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return jsonText.toString();
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
}
