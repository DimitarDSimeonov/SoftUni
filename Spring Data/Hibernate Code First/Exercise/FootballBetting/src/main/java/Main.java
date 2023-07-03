import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("football_betting")
                            .createEntityManager();
    }
}
