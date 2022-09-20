package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        ArrayDeque<Long> fib = new ArrayDeque<>();
        fib.push(0l);
        fib.push(1l);

        if(num < 2){
            System.out.println(1);
            return;
        }
        for (int i = 0; i < num; i++) {
            long firsNum = fib.pop();
            long secondNum = firsNum + fib.peek();
            fib.push(firsNum);
            fib.push(secondNum);
        }
        System.out.println(fib.peek());
    }
}
