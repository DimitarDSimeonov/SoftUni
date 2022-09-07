package students;

public class Students {

    private String firstName;
    private String lastName;
    private String age;
    private String town;

    public Students(String firstName, String lastName, String age, String town){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.town = town;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }
}
