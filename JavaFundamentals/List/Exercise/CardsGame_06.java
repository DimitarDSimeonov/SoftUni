import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstDeck.size() > 0 && secondDeck.size() > 0){
            int firstCard = firstDeck.get(0);
            int secondCard = secondDeck.get(0);
            firstDeck.remove(0);
            secondDeck.remove(0);

                if (firstCard > secondCard){
                    firstDeck.add(firstCard);
                    firstDeck.add(secondCard);

                    }else if (firstCard < secondCard){
                    secondDeck.add(secondCard);
                    secondDeck.add(firstCard);
                }

        }
        if(firstDeck.size() == 0){
            System.out.printf("Second player wins! Sum: %d",sumOfWinDeck(secondDeck));
        }else if (secondDeck.size() == 0) {
            System.out.printf("First player wins! Sum: %d",sumOfWinDeck(firstDeck));
        }

    }
    public static int sumOfWinDeck (List<Integer> deckSize){
        int sum = 0;
        for (int elemen : deckSize){
            sum += elemen;
        }
        return sum;
    }
}
