package definingClassesExercise.opinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);

            if(age > 30){
                Person person = new Person(name, age);
                personList.add(person);
            }
        }
        personList = personList.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        for (Person person : personList){
            System.out.println(person.toString());
        }
    }
}
