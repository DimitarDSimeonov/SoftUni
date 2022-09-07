import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String > inventory = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")){
            String command = input.split(" - ")[0];
            String currentItem = input.split(" - ")[1];

            if (command.contains("Collect")){
                if (!inventory.contains(currentItem)){
                    inventory.add(currentItem);
                }

            }else if (command.contains("Drop")){
                if (inventory.contains(currentItem)){
                    inventory.remove(currentItem);
                }

            }else if (command.contains("Combine Items")){
                String oldItem = currentItem.split(":")[0];
                String newItem = currentItem.split(":")[1];

                if (inventory.contains(oldItem)){
                    int indexOfOldItem = inventory.indexOf(oldItem);
                    inventory.add(indexOfOldItem + 1, newItem);
                }

            }else if(command.contains("Renew")){
                if ( inventory.contains(currentItem)){
                    inventory.remove(currentItem);
                    inventory.add(currentItem);
                }

            }



            input = scanner.nextLine();
        }
        for (int i = 0; i <= inventory.size() - 1; i++) {
            System.out.print(inventory.get(i));
            if (i < inventory.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
