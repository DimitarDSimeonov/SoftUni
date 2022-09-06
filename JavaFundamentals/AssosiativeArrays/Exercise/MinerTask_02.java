import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resourceCount = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceCount.containsKey(resource)){
                resourceCount.put(resource, quantity);
            }else {
                int currentQuantity = resourceCount.get(resource);
                resourceCount.put(resource, currentQuantity + quantity);
            }



            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
