package polymorphismExercise.vehicleExtension;

public class Bus extends Vehicle {

    public static final double CONSUMPTION_WITH_AC = 1.4;

    public Bus(double fuelQuantity, double consumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, consumptionPerKilometer, tankCapacity, CONSUMPTION_WITH_AC);
    }
}
