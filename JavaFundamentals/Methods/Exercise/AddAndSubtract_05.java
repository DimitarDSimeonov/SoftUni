import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        printAddAndSubtractIntegers(a, b, c);

    }
    private static void printAddAndSubtractIntegers (int a, int b, int c){
        int result = (a + b) - c;
        System.out.println(result);
    }
}
