import org.example.mvp_academy.dao.StatsDAO;
import org.example.mvp_academy.model.Stats;

public class TestStatsDAO {

    public static void main(String[] args){
        StatsDAO statsDAO=new StatsDAO();

        Stats stats =StatsDAO.getStatsByUsername("Corsy007");


    }
}
