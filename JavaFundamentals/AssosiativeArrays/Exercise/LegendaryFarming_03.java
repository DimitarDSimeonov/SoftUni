import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Map<String , Integer> legendary = new LinkedHashMap<>();
        legendary.put("shards", 0);
        legendary.put("fragments", 0);
        legendary.put("motes", 0);
        Map <String , Integer> jinkMaterial = new LinkedHashMap<>();

        boolean win = false;

        while(!win){
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if(legendary.containsKey(material)){
                    int currentQuantity = legendary.get(material);
                    legendary.put(material , currentQuantity + quantity);
                }else if (!jinkMaterial.containsKey(material)){
                    jinkMaterial.put(material, quantity);
                }else {
                    int currentQuantity = jinkMaterial.get(material);
                    jinkMaterial.put(material, currentQuantity + quantity);
                }

                if (legendary.get("shards") >= 250){
                    System.out.println("Shadowmourne obtained!");
                    int currentShard = legendary.get("shards");
                    legendary.put("shards", currentShard - 250);
                    win = true;
                    break;

                }else if (legendary.get("fragments") >= 250){
                    System.out.println("Valanyr obtained!");
                    int currentFragments = legendary.get("fragments");
                    legendary.put("fragments", currentFragments - 250);
                    win = true;
                    break;

                }else if (legendary.get("motes") >= 250){
                    System.out.println("Dragonwrath obtained!");
                    int currentMotes = legendary.get("motes");
                    legendary.put("motes", currentMotes - 250);
                    win = true;
                    break;
                }

            }
            if (win){
                break;
            }

            input = scanner.nextLine().split(" ");
        }

        for (Map.Entry<String, Integer> entry : legendary.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : jinkMaterial.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(), entry.getValue());
        }


    }
}
