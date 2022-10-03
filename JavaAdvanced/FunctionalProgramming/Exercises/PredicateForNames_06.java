package functionalProgramingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameSize = Integer.parseInt(scanner.nextLine());
        List<String> listOfNames = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> remove = name -> name.length() > nameSize;

        listOfNames.removeIf(remove);

        listOfNames.forEach(System.out::println);
    }
}
