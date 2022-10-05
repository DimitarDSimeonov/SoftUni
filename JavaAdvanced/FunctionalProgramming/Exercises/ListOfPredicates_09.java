package functionalProgramingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNum = Integer.parseInt(scanner.nextLine());

        List<Integer> divisibleTo = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> isDivisible = num -> {
            for( Integer n : divisibleTo){
                if(num % n != 0){
                    return false;
                }
            }
            return true;
        };

        for (int num = 1; num <= maxNum; num++) {
            if(isDivisible.test(num)){
                System.out.print(num + " ");
            }
        }
    }
}
