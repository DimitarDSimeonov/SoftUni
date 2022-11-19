package polymorphismExercise.vehicleExtension;

public class Car extends Vehicle {

    public static final double CONSUMPTION_WITH_AC = 0.9;

    public Car(double fuelQuantity, double consumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, consumptionPerKilometer, tankCapacity, CONSUMPTION_WITH_AC);
    }
}
