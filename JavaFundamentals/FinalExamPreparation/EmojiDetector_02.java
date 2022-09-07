import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        BigInteger coolCounter = new BigInteger("1");
        boolean counterIsZero = true;

        for (char digit : text.toCharArray()){
            if(Character.isDigit(digit)){
                BigInteger current = new BigInteger(digit + "");
                coolCounter = coolCounter.multiply(current);
                counterIsZero = false;
            }
        }

        Pattern pattern = Pattern.compile("([:]{2}|[\\*]{2})(?<name>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        int emojiCounter = 0;
        List<String> coolEmoji = new ArrayList<>();

        while (matcher.find()){
            emojiCounter++;
            String name = matcher.group("name");
            BigInteger emojiCoolnes = new BigInteger("0");

            for (char letter : name.toCharArray()){
                int letterAsci = (int) letter;
                BigInteger addSum = new BigInteger(letterAsci + "");
                emojiCoolnes = emojiCoolnes.add(addSum);
            }

            if(emojiCoolnes.intValue() > coolCounter.intValue()){
                coolEmoji.add(matcher.group());
            }
        }
        if(counterIsZero){
            System.out.println("Cool threshold: ");
        }else {
            System.out.println("Cool threshold: " + coolCounter);
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCounter);
        for (String emoji : coolEmoji){
            System.out.println(emoji);
        }
    }
}
