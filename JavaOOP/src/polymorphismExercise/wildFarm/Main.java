package polymorphismExercise.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] animalInfo = command.split(" ");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            Animal animal = null;

            switch (animalType) {
                case "polymorphismExercise.wildFarm.Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(animalName, animalType, animalWeight, livingRegion, breed);
                    break;
                case "polymorphismExercise.wildFarm.Tiger":
                    animal = new Tiger(animalName, animalType,animalWeight,livingRegion);
                    break;
                case "polymorphismExercise.wildFarm.Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "polymorphismExercise.wildFarm.Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    break;
            }

            String[] foodInfo = scanner.nextLine().split(" ");

            String foodType = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            Food food = null;

            switch (foodType) {
                case "polymorphismExercise.wildFarm.Meat":
                    food = new Meat(foodQuantity);
                    break;
                case "polymorphismExercise.wildFarm.Vegetable":
                    food = new Vegetable(foodQuantity);
                    break;
            }

            animals.add(animal);
            animal.makeSound();
            animal.eat(food);

            command = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }
}
