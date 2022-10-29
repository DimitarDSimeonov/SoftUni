package workingWithAbstractionExercise.cardWithPower;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardsSuit cardsSuit = CardsSuit.valueOf(scanner.nextLine());

        int cardPower = cardRank.getPower() + cardsSuit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank.name(), cardsSuit.name(), cardPower);
    }
}
