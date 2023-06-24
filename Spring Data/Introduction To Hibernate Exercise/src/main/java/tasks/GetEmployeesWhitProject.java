package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetEmployeesWhitProject {

    public static void run() {

        System.out.println("Enter employee id");
        Scanner scanner = new Scanner(System.in);
        int employeeId = scanner.nextInt();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Employee employee = em.find(Employee.class, employeeId);

        StringBuilder sb = new StringBuilder();

        sb.append(employee.getFirstName() + " " + employee.getLastName() + " - " + employee.getJobTitle())
                .append(System.lineSeparator());
        employee.getProjects()
                .stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> sb.append(p.getName()).append(System.lineSeparator()));

        System.out.println(sb.toString());

        em.getTransaction().commit();
    }
}
