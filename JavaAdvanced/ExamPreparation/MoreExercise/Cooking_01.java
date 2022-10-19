package examPreparationMoreExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Cooking_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> liquidsQueue.offer(e));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> ingredientsStack.push(e));

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquied = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
            int sum = liquied + ingredient;

            switch (sum) {
                case 25:  //bread
                    bread++;
                    break;
                case 50:   //cake
                    cake++;
                    break;
                case 75:   //pastry
                    pastry++;
                    break;
                case 100:  //fruit pie
                    fruitPie++;
                    break;
                default:
                    ingredient += 3;
                    ingredientsStack.push(ingredient);
                    break;
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        }else {
            System.out.println("Liquids left: " + String.join(", ", String.valueOf(liquidsQueue)).replaceAll("[\\[\\]]", ""));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        }else {
            System.out.println("Ingredients left: " + String.join(", ", String.valueOf(ingredientsStack)).replaceAll("[\\[\\]]", ""));
        }

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
