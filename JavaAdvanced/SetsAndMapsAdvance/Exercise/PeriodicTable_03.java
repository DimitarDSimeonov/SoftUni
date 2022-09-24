package setsAndMapsAdvaceExercise;

import java.util.*;

public class PeriodicTable_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int in = 0; in < line; in++) {
            String[] input = scanner.nextLine().split(" ");
            elements.addAll(List.of(input));
        }
        for(String element : elements){
            System.out.print(element + " ");
        }
    }
}
