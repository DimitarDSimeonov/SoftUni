package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int addElements = scanner.nextInt();
        int removeElements = scanner.nextInt();
        int searchingElement = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < addElements; i++) {
            numbers.offer(scanner.nextInt());
        }
        for (int i = 0; i < removeElements; i++) {
            numbers.poll();
        }

        if(numbers.isEmpty()){
            System.out.println(0);

        }else if(numbers.contains(searchingElement)){
            System.out.println("true");

        }else{
            System.out.println(Collections.min(numbers));
        }
    }
}
