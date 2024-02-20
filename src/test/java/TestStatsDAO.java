import org.example.progetto.dao.StatsDAO;
import org.example.progetto.model.Stats;

public class TestStatsDAO {

    public static void main(String[] args){
        StatsDAO statsDAO=new StatsDAO();

        Stats stats =StatsDAO.getStatsByUsername("Corsy007");


    }
}
