import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Persistence.createEntityManagerFactory("sales")
                            .createEntityManager();

        em.getTransaction().begin();

        em.getTransaction().commit();
    }
}
