package functionalProgramingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallest = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer num : list){
                if(num < min){
                    min = num;
                }
            }
            return min;
        };

        System.out.println(numbers.lastIndexOf(smallest.apply(numbers)));
    }
}
