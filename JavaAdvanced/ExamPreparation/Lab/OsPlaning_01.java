package examPraparationLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OsPlaning_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] thread = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int valueOfTask = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        for (int i = 0; i < tasks.length; i++) {
            taskStack.push(tasks[i]);
        }

        for (int i = 0; i < thread.length; i++) {
            threadQueue.offer(thread[i]);
        }

        while (!taskStack.isEmpty()){
            int currentTask = taskStack.peek();
            int currentThread = threadQueue.peek();

            if(currentTask == valueOfTask){
                System.out.printf("Thread with value %d killed task %d%n",currentThread, currentTask);
                break;
            }

            if(currentThread >= currentTask){
                taskStack.pop();
            }
            threadQueue.poll();
        }

        while (!threadQueue.isEmpty()){
            System.out.print(threadQueue.poll() + " ");
        }

    }
}
