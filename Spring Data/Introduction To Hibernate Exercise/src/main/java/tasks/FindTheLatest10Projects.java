package tasks;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheLatest10Projects {

    public static void run() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Project> projects = em.createQuery("FROM Project", Project.class).getResultList();
        Collections.sort(projects, Comparator.comparing(Project::getStartDate));
        Collections.reverse(projects);

        List<Project> lastTenProjects = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lastTenProjects.add(projects.get(i));
        }

        Collections.sort(lastTenProjects, Comparator.comparing(Project::getName));

        lastTenProjects.forEach(p -> System.out.printf("Project name: %s\n" +
                        "Project Description: %s\n" +
                        "Project Start Date:%s\n" +
                        "Project End Date: %s%n%n",
                p.getName(),
                p.getDescription(),
                p.getStartDate(),
                p.getEndDate()));

        em.getTransaction().commit();
    }
}
