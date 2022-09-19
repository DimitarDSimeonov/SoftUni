package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numOfElements = scanner.nextInt();
        int numOfPopElements = scanner.nextInt();
        int searchingNumber = scanner.nextInt();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < numOfElements; i++) {
            numbers.push(scanner.nextInt());
        }

        for (int i = 0; i < numOfPopElements; i++) {
            numbers.pop();
        }
        if(numbers.isEmpty()){
            System.out.println(0);
        }else if(numbers.contains(searchingNumber)){
            System.out.println("true");
        } else{
            for(Integer num : numbers){
                if(num < minNum){
                    minNum = num;
                }
            }
            System.out.println(minNum);
        }
    }
}
