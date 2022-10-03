package functionalProgramingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> add = list -> list.replaceAll(e -> e + 1);
        Consumer<List<Integer>> multiply = list -> list.replaceAll(e -> e * 2);
        Consumer<List<Integer>> subtract = list -> list.replaceAll(e -> e - 1);
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();

        while (!command.equals("end")){
            switch (command){
                case "add":
                    add.accept(numbers);
                    break;
                case "subtract":
                    subtract.accept(numbers);
                    break;
                case "multiply":
                    multiply.accept(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
