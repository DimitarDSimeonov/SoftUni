import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;

        char[] firstWord = input.split(" ")[0].toCharArray();
        char[] secondWord = input.split(" ")[1].toCharArray();

        List<Character> firstListChar = new ArrayList<>();
        List<Character> secondListChar = new ArrayList<>();

        for (char first : firstWord){
            firstListChar.add(first);
        }
        for ( char second : secondWord){
            secondListChar.add(second);
        }

        if (firstListChar.size() > secondListChar.size()){
            for (int i = 0; i < secondListChar.size(); i++) {
                sum +=(int) (firstListChar.get(i)) * (int) (secondListChar.get(i));
                firstListChar.remove(i);
                secondListChar.remove(i);
                i = -1;
            }
            for (char ch : firstListChar){
                sum += (int) ch;
            }
        }else if (firstListChar.size() < secondListChar.size()){
            for (int i = 0; i < firstListChar.size(); i++) {
                sum += (int) (firstListChar.get(i)) * (int) (secondListChar.get(i));
                firstListChar.remove(i);
                secondListChar.remove(i);
                i = -1;
            }
            for (char ch : secondListChar){
                sum += (int) ch;
            }
        }else {
            for (int i = 0; i < firstListChar.size(); i++) {
                sum += (int) (firstListChar.get(i)) * (int) (secondListChar.get(i));
                firstListChar.remove(i);
                secondListChar.remove(i);
                i = -1;
            }
        }
        System.out.println(sum);
    }
}
