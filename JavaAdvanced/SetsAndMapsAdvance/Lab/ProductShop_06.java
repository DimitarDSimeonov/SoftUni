package setsAndmapsAdvanceLab;

import java.util.*;

public class ProductShop_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String,Double>> shopInfo = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")){

            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double  price = Double.parseDouble(input.split(", ")[2]);

            if(!shopInfo.containsKey(shop)){
                LinkedHashMap<String, Double> currentProduct = new LinkedHashMap<>();
                currentProduct.put(product, price);
                shopInfo.put(shop,currentProduct);
            }else {
                shopInfo.get(shop).put(product, price);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : shopInfo.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> products : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", products.getKey(), products.getValue());
            }

        }

    }
}
