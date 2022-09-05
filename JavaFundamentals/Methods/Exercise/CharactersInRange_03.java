import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        printCharactersInInterval(first, second);


    }
    private static void printCharactersInInterval (char one, char two){
        if (one < two){
            for (int i = one + 1; i < two; i++) {
                System.out.print((char)i + " ");

            }
        }else {
            for (int i = two + 1; i < one; i++) {
                System.out.print((char)i + " ");
            }
        }
    }
}
