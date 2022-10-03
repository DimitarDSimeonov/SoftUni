package functionalProgramingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers =  Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> functionMinimum = arr -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if(min > arr[i]){
                    min = arr[i];
                }
            }
            return min;
        };

        int min = functionMinimum.apply(numbers);
        System.out.println(min);
    }
}
