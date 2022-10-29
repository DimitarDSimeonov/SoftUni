package workingWithAbstractionExercise.cardSuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (CardsSuit card : CardsSuit.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card.name());
        }
    }
}
