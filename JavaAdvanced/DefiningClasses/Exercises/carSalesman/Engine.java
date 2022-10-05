package definingClassesExercise.carSalesman;

public class Engine {
    private String engineModel;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine(String engineModel, String power, int displacement, String efficiency){
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, String power, int displacement){
        this(engineModel, power, displacement, "n/a");
    }

    public Engine(String engineModel, String power, String efficiency){
        this(engineModel, power, 0, efficiency);
    }

    public Engine(String engineModel, String power){
        this(engineModel, power, 0, "n/a");
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
