package tasks;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveTowns {

    public static void run() {
        System.out.println("Enter town name");
        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList()
                .stream()
                .filter(e -> e.getAddress() != null && e.getAddress().getTown().getName().equals(townName))
                .collect(Collectors.toList());

        List<Address> addresses = em.createQuery("FROM Address", Address.class).getResultList()
                .stream()
                .filter(a -> a.getTown().getName().equals(townName))
                .collect(Collectors.toList());

        Town town = em.createQuery("FROM Town", Town.class).getResultList()
                .stream()
                .filter(t -> t.getName().equals(townName)).findFirst().get();

        employees.forEach(e -> e.setAddress(null));
        addresses.forEach(a -> em.remove(a));
        em.remove(town);

        System.out.printf("%d address in %s deleted", addresses.size(), townName);


        em.getTransaction().commit();
    }
}
