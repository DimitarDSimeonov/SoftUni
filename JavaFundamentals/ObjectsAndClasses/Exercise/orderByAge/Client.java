package orderByAge;

public class Client {
    private String name;
    private String id;
    private int age;

    public Client(String name, String id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString(){
        String client = String.format("%s with ID: %s is %d years old.",this.name, this.id, this.age);
        return client;
    }
}
