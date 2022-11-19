package polymorphismExercise.vehicles;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double consumptionPerKilometer;

    public Vehicle(double fuelQuantity, double consumptionPerKilometer) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionPerKilometer = consumptionPerKilometer;
    }

    public void refuel(double litre) {
        this.fuelQuantity += litre;
    }

    public String drive(double distance) {
        double neededFuel = distance * getConsumptionPerKilometer();
        if(neededFuel > getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(),df.format(distance));
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumptionPerKilometer() {
        return consumptionPerKilometer;
    }

    public void setConsumptionPerKilometer(double consumptionPerKilometer) {
        this.consumptionPerKilometer = consumptionPerKilometer;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
