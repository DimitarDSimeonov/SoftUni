import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> rarityPlant = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);

            rarityPlant.put(plant, rarity);
        }

        String commands = scanner.nextLine();
        Map<String, List<Double>> ratingPlant = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : rarityPlant.entrySet()) {
            ratingPlant.put(entry.getKey(), new ArrayList<>());
        }


        while (!commands.equals("Exhibition")){
            if(commands.contains("Rate")){
                String information = commands.split(": ")[1];
                String plant = information.split(" - ")[0];
                double rating = Double.parseDouble(information.split(" - ")[1]);

                if(ratingPlant.containsKey(plant)){
                    ratingPlant.get(plant).add(rating);
                }else{
                    System.out.println("error");
                }

            }else if(commands.contains("Update")){
                String information = commands.split(": ")[1];
                String plant = information.split(" - ")[0];
                int rarity = Integer.parseInt(information.split(" - ")[1]);

                if(rarityPlant.containsKey(plant)){
                    rarityPlant.put(plant, rarity);
                }else{
                    System.out.println("error");
                }

            }else if (commands.contains("Reset")){
                String plant = commands.split(": ")[1];
                if(ratingPlant.containsKey(plant)){
                    ratingPlant.put(plant, new ArrayList<>());
                   // ratingPlant.get(plant).add(0.00);
                }else{
                    System.out.println("error");
                }

            }
            commands = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Double>> entry : ratingPlant.entrySet()) {
            double ratingSum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                ratingSum += entry.getValue().get(i);
            }
            double average = ratingSum / entry.getValue().size();
            if(entry.getValue().size() > 0) {
                System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), rarityPlant.get(entry.getKey()), average);
            }else{
                System.out.printf("- %s; Rarity: %d; Rating: 0.00%n", entry.getKey(), rarityPlant.get(entry.getKey()));
            }
        }

    }
}
