package students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String studentDate = scanner.nextLine();
            String firsName = studentDate.split(" ")[0];
            String lastName = studentDate.split(" ")[1];
            double grade = Double.parseDouble(studentDate.split(" ")[2]);

            Students student = new Students(firsName, lastName, grade);
            studentsList.add(student);
        }

        studentsList.sort(Comparator.comparing(Students::getGrade).reversed());
        for (Students students : studentsList){
            System.out.println(students.toString());
        }
    }
}
