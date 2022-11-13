package interfaceAndAbstractionExercise.foodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {

            String[] buyerInfo = scanner.nextLine().split(" ");
            String name = buyerInfo[0];
            int age = Integer.parseInt(buyerInfo[1]);

            if (buyerInfo.length == 3) {
                String group = buyerInfo[2];
                Rebel rebel = new Rebel(name, age, group);
                buyerMap.put(name, rebel);

            }else if (buyerInfo.length == 4) {
                String id = buyerInfo[2];
                String birthDate = buyerInfo[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyerMap.put(name, citizen);
            }
        }

        String buyer = scanner.nextLine();

        while (!"End".equals(buyer)) {

            if (buyerMap.containsKey(buyer)) {
                buyerMap.get(buyer).buyFood();
            }

            buyer = scanner.nextLine();
        }

        System.out.println(buyerMap.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
