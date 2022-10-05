package definingClassesExercise.rawData;

import java.util.Arrays;

public class Car {
    private String model;
    private int power;
    private String cargoType;
    private double[] pressure;

    public Car(String model, int power, String cargoType, double[] pressure){
        this.model = model;
        this.power = power;
        this.cargoType = cargoType;
        this.pressure = pressure;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public double[] getPressure() {
        return pressure;
    }

    public void setPressure(double[] pressure) {
        this.pressure = pressure;
    }
    public boolean isGoodPressure (double[] pressure){
        double average = Arrays.stream(pressure).sum() / 4;
        return average < 1;
    }
    public boolean powerIsGood(int power){
        return power > 250;
    }
}
