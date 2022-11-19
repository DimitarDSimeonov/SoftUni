package polymorphismExercise.vehicleExtension;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double consumptionPerKilometer;
    private double tankCapacity;
    private double addConsumptionForAc;

    public Vehicle(double fuelQuantity, double consumptionPerKilometer, double tankCapacity, double addConsumptionForAc) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionPerKilometer = consumptionPerKilometer;
        this.tankCapacity = tankCapacity;
        this.addConsumptionForAc = addConsumptionForAc;
    }

    public void refuel(double litre) {
        if (litre <= 0 ){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double emptyValue = tankCapacity - fuelQuantity;
        if (emptyValue < litre) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
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

    public String driveWithAc(double distance) {
        setConsumptionPerKilometer(this.consumptionPerKilometer + addConsumptionForAc);
        String result = this.drive(distance);
        setConsumptionPerKilometer(this.consumptionPerKilometer - addConsumptionForAc);
        return result;
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
