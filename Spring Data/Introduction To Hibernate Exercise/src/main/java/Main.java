import entities.*;
import tasks.ContainsEmployee;
import tasks.EmployeesFromDepartment;
import tasks.IncreaseSalaries;
import tasks.RemoveTowns;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
            //ТЕСТВАНЕТО НА 6-ТА МОЖЕ ДА СЧУПИ БАЗАТА ЗА РЕШЕНИЕТО НА 7-МА



        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Department> departments = em.createQuery("SELECT d.name, MAX(e.salary) AS max_salary FROM Department AS d\n" +
                        "JOIN Employee AS e ON e.department_id = d.id\n" +
                        "GROUP BY d.id\n" +
                        "HAVING max_salary < 30000 OR max_salary > 70000", Department.class).getResultList()
                        .stream()
                        .collect(Collectors.toList());

        departments.forEach(d -> d.getEmployees().stream().max((f, s) -> f.getSalary().compareTo(s.getSalary())).get());

        em.getTransaction().commit();
    }
}
