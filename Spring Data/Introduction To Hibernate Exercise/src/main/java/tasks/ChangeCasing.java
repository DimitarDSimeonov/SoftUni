package tasks;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class ChangeCasing {

    public static void run() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Town> towns = em.createQuery("FROM Town", Town.class).getResultList();
        towns.forEach(t -> {
            if(t.getName().length() > 5) {
                t.setName(t.getName().toUpperCase(Locale.ROOT));
            }
        });
        em.getTransaction().commit();

    }
}
