import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChar(input);
    }
    private static void printMiddleChar (String input){
        if (input.length() % 2 == 0){
            char two = input.charAt(input.length()/2);
            char one = input.charAt(input.length()/2 - 1);
            System.out.println("" + one + two);
        }else {
            char one = input.charAt(input.length()/2);
            System.out.println(one);
        }
    }
}
