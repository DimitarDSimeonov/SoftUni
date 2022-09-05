import java.util.Locale;
import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        printVowelsCount(input);


    }
    private static void printVowelsCount (String input){
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            switch (symbol){
                case 'a':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                case 'e':
                    count++;
                    break;
                case 'y':
                    count++;
                    break;

            }
        }
        System.out.println(count);
    }
}
