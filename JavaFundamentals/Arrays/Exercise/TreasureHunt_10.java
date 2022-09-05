import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsArr = scanner.nextLine().split("\\|");
        String[] commands = scanner.nextLine().split(" ");

        while (!commands[0].equals("Yohoho!")){
            switch (commands[0]){
                case "Loot":
                    for (int i = 1; i <= commands.length - 1; i++) {
                       boolean partIn = true;
                        for (int j = 0; j <= itemsArr.length - 1; j++) {
                            if(commands[i].equals(itemsArr[j])){
                                partIn = false;
                                break;
                            }
                        }
                        if(partIn){
                            String chest = commands[i] + " " + String.join(" ", itemsArr);
                            itemsArr = chest.split(" ");
                        }
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(commands[1]);
                    if (index <= itemsArr.length-1 && index >= 0){
                        String dropItem = itemsArr[index];
                        for (int i = index; i < itemsArr.length-1; i++) {
                            itemsArr[i] = itemsArr[i+1];
                        }
                        itemsArr[itemsArr.length-1] = dropItem;
                    } else {
                        break;
                    }
                    break;

                case "Steal":
                    int numOfStealingItem = Integer.parseInt(commands[1]);
                    if (numOfStealingItem >= 0 && numOfStealingItem < itemsArr.length){
                        for (int i = 0; i < numOfStealingItem; i++) {
                            System.out.print(itemsArr[itemsArr.length - numOfStealingItem + i]);
                            if ( i != numOfStealingItem-1){
                                System.out.print(", ");
                            }
                        }
                        String[] tempChest = new String[itemsArr.length - numOfStealingItem];
                        for (int i = 0; i < tempChest.length; i++) {
                            tempChest[i] = itemsArr[i];
                        }
                        itemsArr = tempChest;
                    }else if (numOfStealingItem >= 0){
                        for (int i = 0; i < itemsArr.length; i++) {
                            System.out.print(itemsArr[i]);
                            if (i != itemsArr.length-1) {
                                System.out.print(", ");
                            }
                        }
                            itemsArr = new String[0];
                    }
                    System.out.println();

                    break;
            }

            commands = scanner.nextLine().split(" ");
        }
        String treasureCount = String.join("",itemsArr);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }
        double averageTreasure = (1.0 * charCounter) / itemsArr.length;
        if (charCounter > 0){
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        }else{
            System.out.println("Failed treasure hunt.");
        }
    }
}