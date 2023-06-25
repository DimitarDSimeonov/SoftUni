package tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesMaximumSalaries {

    public static void run() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("SELECT department.name, max(salary) AS mSalary " +
                        "FROM Employee " +
                        "GROUP BY department.name " +
                        "HAVING max(salary) NOT BETWEEN 30000 AND 70000", Object[].class).getResultList()
                .forEach(o -> System.out.println(o[0] + " " + o[1]));


        em.getTransaction().commit();
    }
}
