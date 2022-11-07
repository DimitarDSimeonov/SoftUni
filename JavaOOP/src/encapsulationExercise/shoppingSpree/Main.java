package encapsulationExercise.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInfo = scanner.nextLine().split(";");
        Map<String,Person> personMap = new LinkedHashMap<>();

        for (String people : personInfo) {
            String personName = people.split("=")[0];
            double  personMoney = Double.parseDouble(people.split("=")[1]);

            try {
                Person person = new Person(personName, personMoney);
                personMap.put(personName, person);
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
                return;
            }
        }

        String[] productInfo = scanner.nextLine().split(";");
        Map<String, Product> productMap = new LinkedHashMap<>();

        for (String p : productInfo) {
            String productName = p.split("=")[0];
            double price = Double.parseDouble(p.split("=")[1]);
            try {
                Product product = new Product(productName, price);
                productMap.put(productName, product);
            }catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }

        }

        String command = scanner.nextLine();

        while (!"END".equals(command)) {
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];

            Person person = personMap.get(personName);
            Product product = productMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n",personName, productName);
            }catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            command = scanner.nextLine();
        }

        personMap.values().forEach(System.out::println);
    }
}
