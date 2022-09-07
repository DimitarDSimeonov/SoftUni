package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Students> studentsList = new ArrayList<>();

        while (!input.equals("end")){
            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            String age = input.split(" ")[2];
            String town = input.split(" ")[3];

            Students student = new Students(firstName, lastName, age, town);
            studentsList.add(student);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        for (Students student : studentsList){
            if (command.equals(student.getTown())){
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
