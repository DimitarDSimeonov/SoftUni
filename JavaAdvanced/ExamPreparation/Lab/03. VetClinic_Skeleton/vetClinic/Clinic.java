package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(data.size() < capacity && data.stream().noneMatch(p -> p.getName().equals(pet.getName()) && p.getOwner().equals(pet.getOwner()))){
            data.add(pet);
        }
    }
    
    public boolean remove(String name){
       return data.removeIf(p -> p.getName().equals(name));
       
    }
    public Pet getPet(String name, String owner){
        if(data.stream().anyMatch(p-> p.getName().equals(name) && p.getOwner().equals(owner))){
            Pet current = data.stream().filter(p-> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().get();
            return current;
        }
        return null;
    }

    public Pet getOldestPet(){
        if(data.size() == 0){
            throw new IllegalArgumentException("Clinic is empty!");
        }
        if(data.size() == 1){
            return data.get(0);
        }
        Pet pet = data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
        return pet;
    }

    public int getCount(){
        return data.size();
    }

    public  String getStatistics(){
        if(data.size() == 0){
            return "The clinic has the following patients:";
        }
         var sb = new StringBuilder();
         sb.append(String.format("The clinic has the following patients:%n"));
         data.forEach(e -> sb.append(String.format("%s %s%n",e.getName(), e.getOwner()) ));
         return sb.toString();
    }
}
