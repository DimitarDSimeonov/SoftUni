package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            numbers.push(input[i]);
        }
        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }

    }
}
