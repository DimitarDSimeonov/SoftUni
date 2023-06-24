package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IncreaseSalaries {

    public static void run() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList()
                .stream()
                .filter(e -> e.getDepartment().getName().equals("Engineering")
                        || e.getDepartment().getName().equals("Tool Design")
                        || e.getDepartment().getName().equals("Marketing")
                        || e.getDepartment().getName().equals("Information Services"))
                .collect(Collectors.toList());

        Collections.sort(employees, Comparator.comparing(e -> e.getDepartment().getName()));

        employees.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        employees.forEach(e -> System.out.printf("%s %s ($%s)%n",
                e.getFirstName(),
                e.getLastName(),
                e.getSalary().toString()));

        em.getTransaction().commit();
    }
}
