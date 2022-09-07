import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@|#])(?<first>[A-Z+a-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(words);

        List<String> mirrorWords = new ArrayList<>();
        int wordCounter = 0;

        while (matcher.find()){
            wordCounter++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            StringBuilder reversed = new StringBuilder();
            reversed.append(secondWord).reverse();

            if(reversed.toString().equals(firstWord)){
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }

        }

        if(wordCounter <= 0){
            System.out.println("No word pairs found!");
        }else {
            System.out.println(wordCounter + " word pairs found!");
        }

        if (mirrorWords.isEmpty()){
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are: ");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}
