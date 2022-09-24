package setsAndMapsAdvaceExercise;

import java.util.*;

public class HandsOfCards_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> handCard = new LinkedHashMap<>();

        while (!input.equals("JOKER")){

            String name = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", ");
            handCard.putIfAbsent(name, new HashSet<>());

            for(String card : cards){
                handCard.get(name).add(card);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : handCard.entrySet()) {
            int points = 0;
            for (String card : entry.getValue()){
                int cardPoints = 0;
                String cardType = card.substring(0,card.length() - 1);
                if (cardType.equals("2")){
                    cardPoints = 2;
                }else if(cardType.equals("3")){
                    cardPoints = 3;
                }else if(cardType.equals("4")){
                    cardPoints = 4;
                }else if(cardType.equals("5")){
                    cardPoints = 5;
                }else if(cardType.equals("6")){
                    cardPoints = 6;
                }else if(cardType.equals("7")){
                    cardPoints = 7;
                }else if(cardType.equals("8")){
                    cardPoints = 8;
                }else if(cardType.equals("9")){
                    cardPoints = 9;
                }else if(cardType.equals("10")){
                    cardPoints = 10;
                }else if(cardType.equals("J")){
                    cardPoints = 11;
                }else if(cardType.equals("Q")){
                    cardPoints = 12;
                }else if(cardType.equals("K")){
                    cardPoints = 13;
                }else if(cardType.equals("A")){
                    cardPoints = 14;
                }

                if(card.endsWith("S")){
                    cardPoints *= 4;
                }else if (card.endsWith("H")){
                    cardPoints *= 3;
                }else if(card.endsWith("D")){
                    cardPoints *= 2;
                }else if(card.endsWith("C")){
                    cardPoints *= 1;
                }
                points += cardPoints;
            }

            System.out.printf("%s: %d%n",entry.getKey(), points);
        }

    }
}
