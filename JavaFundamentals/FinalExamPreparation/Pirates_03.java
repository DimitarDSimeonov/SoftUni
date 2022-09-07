import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> cites = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int people = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if (!cites.containsKey(city)) {
                cites.put(city, new ArrayList<>());
                cites.get(city).add(people);
                cites.get(city).add(gold);
            } else {
                int currentPeople = cites.get(city).get(0);
                int currentGold = cites.get(city).get(1);
                cites.get(city).set(0, currentPeople + people);
                cites.get(city).set(1, currentGold + gold);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Plunder")) { //{town}=>{people}=>{gold}"
                String town = command.split("=>")[1];
                int people = Integer.parseInt(command.split("=>")[2]);
                int gold = Integer.parseInt(command.split("=>")[3]);
                int currentPeople = cites.get(town).get(0);
                int currentGold = cites.get(town).get(1);

                cites.get(town).set(0, currentPeople - people);
                cites.get(town).set(1, currentGold - gold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                if (cites.get(town).get(0) <= 0 || cites.get(town).get(1) <= 0) {
                    cites.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }


            } else if (command.contains("Prosper")) { //{town}=>{gold}
                String town = command.split("=>")[1];
                int gold = Integer.parseInt(command.split("=>")[2]);
                int currentGold = cites.get(town).get(1);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cites.get(town).set(1, currentGold + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, cites.get(town).get(1));
                }

            }
            command = scanner.nextLine();
        }

        if (cites.size() > 0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cites.size());
            for (Map.Entry<String, List<Integer>> entry : cites.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");

        }

     }
  }

