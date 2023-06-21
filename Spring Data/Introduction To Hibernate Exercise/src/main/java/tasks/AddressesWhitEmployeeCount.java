package tasks;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressesWhitEmployeeCount {

    public static void run() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Address> addresses = em.createQuery("FROM Address", Address.class).getResultList();
        Collections.sort(addresses, Comparator.comparing(a -> a.getEmployees().size()));
        Collections.reverse(addresses);

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s, %s - %d employees%n",
                    addresses.get(i).getText(),
                    addresses.get(i).getTown().getName(),
                    addresses.get(i).getEmployees().size());
        }

        em.getTransaction().commit();
    }
}
