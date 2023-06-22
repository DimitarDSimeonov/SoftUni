package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class EmployeesWhitSalaryOver50000 {

    public static void run() {

        long salary = 50000;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList();
        employees.forEach(employee -> {
            if (employee.getSalary().compareTo(BigDecimal.valueOf(salary)) == 1) {
                System.out.println(employee.getFirstName());
            }
        });

        em.getTransaction().commit();
    }
}
