package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numOfRotation = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> child = new ArrayDeque<>();

        for (String name : input){
            child.offer(name);
        }

        while (child.size() > 1){

            for (int i = 1; i < numOfRotation; i++) {
                String currentChild = child.poll();
                child.offer(currentChild);
            }

            System.out.println("Removed " + child.poll());

        }

        System.out.println("Last is " + child.peek());
    }
}
