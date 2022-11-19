package polymorphismExercise.wildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(!food.getClass().getSimpleName().equals("polymorphismExercise.wildFarm.Vegetable")){
            System.out.println("Mice are not eating that type of food!");
        }else {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        }
    }
}
