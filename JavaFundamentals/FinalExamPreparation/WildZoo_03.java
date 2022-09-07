import java.util.*;

public class WildZoo_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> animals = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();
        Map<String, String> animalsArea = new LinkedHashMap<>();

        while (!command.equals("EndDay")){
            if (command.contains("Add")){ //o	"Add: {animal_name}-{needed_food_quantity}-{area}"
                String info = command.split(": ")[1];
                String animalName = info.split("-")[0];
                int foodLimit = Integer.parseInt(info.split("-")[1]);
                String areaName = info.split("-")[2];

                if(!animals.containsKey(animalName)){
                    animals.put(animalName, foodLimit);
                    if (!areas.containsKey(areaName)){
                        areas.put(areaName, 1);
                    }else{
                        int currentAngryAnimal = areas.get(areaName);
                        areas.put(areaName, currentAngryAnimal + 1);
                    }
                }else {
                    int currentFoodLimit = animals.get(animalName);
                    animals.put(animalName, currentFoodLimit + foodLimit);
                }
                animalsArea.put(animalName, areaName);


            }else if (command.contains("Feed")){ //o	"Feed: {animalName}-{food}"
                String info = command.split(": ")[1];
                String animalName = info.split("-")[0];
                int food = Integer.parseInt(info.split("-")[1]);
                if(animals.containsKey(animalName)){
                    int currentFood = animals.get(animalName);
                    animals.put(animalName, currentFood - food);
                    if(animals.get(animalName) <= 0){
                        System.out.println(animalName + " was successfully fed");
                        animals.remove(animalName);
                        String area = animalsArea.get(animalName);
                        int currentAngryAnimal = areas.get(area);
                        areas.put(area, currentAngryAnimal - 1);
                        if (areas.get(area) <= 0){
                            areas.remove(area);
                        }
                    }
                }

            }
            command = scanner.nextLine();
        }
        System.out.println("Animals:");
        for (Map.Entry<String, Integer> entry : animals.entrySet()) {
            System.out.printf(" %s -> %dg%n",entry.getKey(), entry.getValue());
        }

        System.out.println("Areas with hungry animals:");
        for (Map.Entry<String, Integer> entry : areas.entrySet()) {
            System.out.printf(" %s: %d%n",entry.getKey(), entry.getValue());
        }


    }
}
