package functionalProgramingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (f,s) ->{
            if(f % 2 == 0 && s % 2 != 0){
                return -1;
            }else if(f % 2 != 0 && s % 2 == 0){
                return 1;
            }
            return f.compareTo(s);
        };

        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
