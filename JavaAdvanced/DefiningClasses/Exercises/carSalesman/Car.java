package definingClassesExercise.carSalesman;

import java.util.stream.Stream;

public class Car {
    private String carModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String carModel, Engine engine, int weight, String color){
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String carModel, Engine engine, int weight){
        this(carModel, engine, weight, "n/a");
    }
    public Car(String carModel, Engine engine, String color){
        this(carModel, engine, 0, color);
    }
    public Car(String carModel, Engine engine){
        this(carModel, engine, 0, "n/a");
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
        return String.format("%s:%n" +
                "%s:%n" +
                "Power: %s%n" +
                "Displacement: %d%n" +
                "Efficiency: %s%n" +
                "Weight: %d%n" +
                "Color: %s",this.carModel, this.engine.getEngineModel(), this.engine.getPower(), this.engine.getDisplacement(),
                this.engine.getEfficiency(), this.weight, this.color).replaceAll(" 0"," n/a");
    }
}
