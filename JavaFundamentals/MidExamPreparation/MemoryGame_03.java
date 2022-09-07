import java.util.*;
import java.util.stream.Collectors;

public class MemoryGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int moves = 0;
        boolean lose = true;

        while (!input.equals("end")){
            moves++;
            int firstIndex = Integer.parseInt(input.split(" ")[0]);
            int secondIndex = Integer.parseInt(input.split(" ")[1]);

            if(firstIndex == secondIndex){
                numbers.add(numbers.size()/2 , "-" + moves + "a");
                numbers.add(numbers.size()/2 + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");

            }else if ( firstIndex < 0 || firstIndex >= numbers.size()){
                numbers.add(numbers.size()/2 , "-" + moves + "a");
                numbers.add(numbers.size()/2 + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");

            }else if ( secondIndex < 0 || secondIndex >= numbers.size()) {
                numbers.add(numbers.size() / 2, "-" + moves + "a");
                numbers.add(numbers.size() / 2 + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }else if(firstIndex >= 0 && firstIndex < numbers.size() && secondIndex >= 0 && secondIndex < numbers.size()) {

                if (numbers.get(firstIndex).equals(numbers.get(secondIndex))) {
                    String deletedItem = numbers.get(firstIndex);
                    numbers.removeAll(Collections.singleton(numbers.get(firstIndex)));
                    System.out.printf("Congrats! You have found matching elements - %s!%n", deletedItem);
                } else {
                    System.out.println("Try again!");
                }

                if (numbers.size() == 0) {
                    System.out.printf("You have won in %d turns!", moves);
                    lose = false;
                    break;
                }
            }

            input = scanner.nextLine();
        }
        if(lose) {
            System.out.println("Sorry you lose :(");
            for (String element : numbers) {
                System.out.print(element + " ");
            }
        }
    }
}
