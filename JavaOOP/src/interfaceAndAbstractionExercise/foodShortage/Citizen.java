package interfaceAndAbstractionExercise.foodShortage;

public class Citizen implements Identifiable, Birthable, Person, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }
    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "interfaceAndAbstractionExercise.multipleImplementation.interfaceAndAbstractionExercise.birthdayCelebrations.interfaceAndAbstractionExercise.foodShortage.Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public void buyFood() {
        food += 10;
    }

    @Override
    public int getFood() {
        return food;
    }
}
