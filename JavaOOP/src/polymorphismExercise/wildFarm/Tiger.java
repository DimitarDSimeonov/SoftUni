package polymorphismExercise.wildFarm;

public class Tiger extends Feline {

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(!"polymorphismExercise.wildFarm.Meat".equals(food.getClass().getSimpleName())) {
            System.out.println("Tigers are not eating that type of food!");
        }else {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        }
    }
}
