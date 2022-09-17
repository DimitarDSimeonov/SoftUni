package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numOfRotation = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> child = new ArrayDeque<>();

        for (String name : input){
            child.offer(name);
        }

        int games = 1;

        while (child.size() > 1){

            for (int i = 1; i < numOfRotation; i++) {
                String currentChild = child.poll();
                child.offer(currentChild);
            }

            if (isPrime(games)){
                System.out.println("Prime " + child.peek());
            }else{
                System.out.println("Removed " + child.poll());
            }
            games++;

        }

        System.out.println("Last is " + child.peek());
    }

    public static boolean isPrime (int n){
        if(n < 2){
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
