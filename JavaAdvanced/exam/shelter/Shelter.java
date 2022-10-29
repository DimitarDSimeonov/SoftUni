package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf((e -> e.getName().equals(name)));
    }

    public Animal getAnimal(String  name, String caretaker) {
        return data.stream().filter(e -> e.getName().equals(name) && e.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal(){
        return Collections.max(data,(f,s) -> Integer.compare(f.getAge(), s.getAge()));
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics() {
        var sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal a : data){
            sb.append(String.format("%s %s", a.getName(), a.getCaretaker())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
