package exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(e -> caffeine.push(e));

        ArrayDeque<Integer> drinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(e -> drinks.offer(e));

        int stamatCaffeine = 0;

        while (!caffeine.isEmpty() && !drinks.isEmpty()){
            int currentCaffeine = caffeine.pop();
            int currentDrink = drinks.poll();

            int sum = currentDrink * currentCaffeine;

            if(stamatCaffeine + sum <= 300){
                stamatCaffeine += sum;
            }else {
                drinks.offer(currentDrink);
                if(stamatCaffeine - 30 > 0){
                    stamatCaffeine -= 30;
                }
            }
        }
        if (drinks.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }else {
            System.out.println("Drinks left: " + String.join(", ", String.valueOf(drinks).replaceAll("[\\[\\]]", "")));
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatCaffeine);
    }
}
