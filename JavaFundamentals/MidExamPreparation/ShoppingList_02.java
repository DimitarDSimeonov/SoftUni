import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shopingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")){
            String command = input.split(" ")[0];
            String product = input.split(" ")[1];
            switch (command){
                case "Urgent":
                    if (!shopingList.contains(product)){
                        shopingList.add(0, product);
                    }
                    break;
                case "Unnecessary":
                    if (shopingList.contains(product)){
                        shopingList.remove(product);
                    }
                    break;
                case "Correct":
                    String newProduct = input.split(" ")[2];
                    if (shopingList.contains(product)){
                        int indexProduct = shopingList.indexOf(product);
                        shopingList.set(indexProduct, newProduct);
                    }
                    break;
                case "Rearrange":
                    if (shopingList.contains(product)){
                        shopingList.remove(product);
                        shopingList.add(product);
                    }
                    break;
            }



            input = scanner.nextLine();
        }
        for (int i = 0; i < shopingList.size(); i++) {
            System.out.print(shopingList.get(i));
            if (i < shopingList.size() -1){
                System.out.print(", ");
            }
        }
    }
}
