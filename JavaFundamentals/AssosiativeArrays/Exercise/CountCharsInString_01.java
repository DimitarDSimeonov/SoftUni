import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> text = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (currentChar.equals(' ')){
                continue;
            }

            if(!text.containsKey(currentChar)){
                text.put(currentChar, 1);
            }else {
                int currentCount = text.get(currentChar);
                text.put(currentChar, currentCount + 1);
            }

        }
        for (Map.Entry<Character, Integer> entry : text.entrySet()) {
            System.out.printf("%c -> %d%n",entry.getKey(), entry.getValue());
        }

    }
}
