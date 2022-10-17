package examPreparationMoreExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(e -> liliesStack.push(e));

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(e -> rosesQueue.offer(e));

        int wreathsCount = 0;
        int flowerSum = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int lilie = liliesStack.pop();
            int rose = rosesQueue.poll();

            if( lilie + rose == 15) {
                wreathsCount++;

            }else if (lilie + rose < 15) {
                flowerSum += lilie + rose;

            }else if (lilie + rose > 15) {
                while (lilie + rose > 15) {
                    lilie -= 2;
                }
                if( lilie + rose == 15) {
                    wreathsCount++;

                }else if (lilie + rose < 15) {
                    flowerSum += lilie + rose;

                }
            }
        }
        wreathsCount += flowerSum / 15;

        if (wreathsCount >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!" ,wreathsCount);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!" ,5 - wreathsCount);
        }
    }
}
