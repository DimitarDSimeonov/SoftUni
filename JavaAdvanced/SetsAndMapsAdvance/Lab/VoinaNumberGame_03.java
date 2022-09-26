package setsAndmapsAdvanceLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            firstPlayer.add(scanner.nextInt());
        }

        for (int i = 0; i < 20; i++) {
            secondPlayer.add(scanner.nextInt());
        }
        int games = 50;

        while (games > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()){

            games--;
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);

            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            }else if (firstCard < secondCard){
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else if (firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
