package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindEmployeesByFirstName {

    public static void run() {

        System.out.println("Enter pattern");
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine().toLowerCase(Locale.ROOT);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList()
                .stream()
                .filter(e -> e.getFirstName().toLowerCase(Locale.ROOT).startsWith(pattern))
                .collect(Collectors.toList());

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%s)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary().toString()));

        em.getTransaction().commit();
    }
}
