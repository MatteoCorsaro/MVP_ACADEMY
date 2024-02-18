import org.example.mvp_academy.Dao.StatsDAO;
import org.example.mvp_academy.Model.Stats;

public class TestStatsDAO {

    public static void main(String[] args){
        StatsDAO statsDAO=new StatsDAO();

        Stats stats =StatsDAO.getStatsByUsername("Corsy007");


    }
}
