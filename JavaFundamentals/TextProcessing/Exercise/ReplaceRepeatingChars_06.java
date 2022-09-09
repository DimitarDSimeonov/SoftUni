import java.util.Scanner;

public class ReplaceRepeatingChars_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder repearText = new StringBuilder();

        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            if(currentChar != nextChar){
                repearText.append(currentChar);
            }
            if(i == input.length()-2){
                repearText.append(nextChar);
            }
        }
        System.out.println(repearText);
    }
}
