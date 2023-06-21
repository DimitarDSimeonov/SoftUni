package tasks;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AddingNewAddressAndUpdatingEmployee {

    public static void run() {

        System.out.println("Enter the employee last name");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        em.persist(address);

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList();
        Employee employee = employees.stream().filter(e -> e.getLastName().equals(lastName)).findFirst().orElse(null);
        if (employee != null) {
            employee.setAddress(address);
        }

        em.getTransaction().commit();
    }
}
