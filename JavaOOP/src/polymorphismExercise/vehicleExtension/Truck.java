package polymorphismExercise.vehicleExtension;

public class Truck extends Vehicle {

    public static final double CONSUMPTION_WITH_AC = 1.6;
    public static final double REFUELING_COEFFICIENT = 0.95;

    public Truck(double fuelQuantity, double consumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, consumptionPerKilometer, tankCapacity, CONSUMPTION_WITH_AC);
    }

    @Override
    public void refuel(double litre) {
        super.refuel(litre * REFUELING_COEFFICIENT);
    }
}
