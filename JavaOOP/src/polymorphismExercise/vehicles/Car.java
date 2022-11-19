package polymorphismExercise.vehicles;

public class Car extends Vehicle {

    public static final double CONSUMPTION_WITH_AC = 0.9;

    public Car(double fuelQuantity, double consumptionPerKilometer) {
        super(fuelQuantity, consumptionPerKilometer + CONSUMPTION_WITH_AC);
    }
}
