package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesFromDepartment {

    public static void run() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList().stream().toList();
        List<Employee> researchAndDevelopment = employees.stream()
                .filter(e -> e.getDepartment().getName().equals("Research and Development"))
                .collect(Collectors.toList());
        Collections.sort(researchAndDevelopment, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getId));

        researchAndDevelopment.forEach(e -> System.out.println(e.getFirstName() + " "+ e.getLastName() + " from "
                + e.getDepartment().getName() + " - $" + e.getSalary()));

        em.getTransaction().commit();
    }
}
