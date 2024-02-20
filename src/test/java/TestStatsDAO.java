import org.example.mvpAcademy.dao.StatsDAO;
import org.example.mvpAcademy.model.Stats;

public class TestStatsDAO {

    public static void main(String[] args){
        StatsDAO statsDAO=new StatsDAO();

        Stats stats =StatsDAO.getStatsByUsername("Corsy007");


    }
}
