package encapsulationExercise.pizzaCalories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split(" ");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scanner.nextLine().split(" ");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double doughWeight = Double.parseDouble(doughInfo[3]);

        String toppingInfo = scanner.nextLine();

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            while (!"END".equals(toppingInfo)){

                String toppingType = toppingInfo.split(" ")[1];
                double toppingWeight = Double.parseDouble(toppingInfo.split(" ")[2]);

                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);

                toppingInfo = scanner.nextLine();
            }

            System.out.printf("%s - %.2f",pizza.getName(), pizza.getOverallCalories());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return;
        }


    }
}
