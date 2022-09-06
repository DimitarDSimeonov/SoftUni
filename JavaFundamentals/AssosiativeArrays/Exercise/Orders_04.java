import java.util.*;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map <String, List<Double> > shopping = new LinkedHashMap<>();

        while (!input.equals("buy")){
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            double quantity = Double.parseDouble(input.split(" ")[2]);

            if (!shopping.containsKey(product)){
                shopping.put(product, new ArrayList<>());
                shopping.get(product).add(price);
                shopping.get(product).add(quantity);
            }else {
                double currentPrice = shopping.get(product).get(0);
                double currentQuantity = shopping.get(product).get(1);
                shopping.get(product).set(0, price);
                shopping.get(product).set(1, currentQuantity + quantity);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : shopping.entrySet()) {
            System.out.printf("%s -> %.2f%n",entry.getKey(), entry.getValue().get(0) * entry.getValue().get(1));
        }

    }
}
