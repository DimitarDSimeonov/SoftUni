import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if(Character.isDigit(currentChar)){
                digit.append(currentChar);
            }else if (Character.isLetter(currentChar)){
                letter.append(currentChar);
            }else if (!Character.isLetterOrDigit(currentChar)){
                other.append(currentChar);
            }
        }
        System.out.println(digit);
        System.out.println(letter);
        System.out.println(other);
    }
}
