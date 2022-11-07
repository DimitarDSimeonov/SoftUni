package encapsulationExercise.pizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType (String flourType){
        if (!"White".equals(flourType) && !"Wholegrain".equals(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique (String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique) && !"Chewy".equals(bakingTechnique) && !"Homemade".equals(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight (double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeCalorieModifiers = 0;
        double brakingTechniqueCalorieModifier = 0;

        switch (flourType) {
            case "White":
                flourTypeCalorieModifiers = 1.5;
                break;
            case "Wholegrain":
                flourTypeCalorieModifiers = 1.0;
                break;
        }
        switch (bakingTechnique) {
            case "Crispy":
                brakingTechniqueCalorieModifier = 0.9;
                break;
            case "Chewy":
                brakingTechniqueCalorieModifier = 1.1;
                break;
            case "Homemade":
                brakingTechniqueCalorieModifier = 1.0;
                break;
        }

        return (2 * weight) * flourTypeCalorieModifiers * brakingTechniqueCalorieModifier;
    }
}
