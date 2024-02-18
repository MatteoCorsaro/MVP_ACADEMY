public class TestFileManager {
    public static void main(String[] args){
        FileManager fileManager =new FileManager();
        String filename="C:\\Users\\Matteo\\OneDrive\\Desktop\\Progetto\\5 Code\\MVP_ACADEMY\\Stats.json";

        //System.out.println(fileManager.getJSONFromFile(filename));

        System.out.println(fileManager.getStats(fileManager.getJSONFromFile(filename),"Corsy007","mid_stats",null,null));
    }
}
