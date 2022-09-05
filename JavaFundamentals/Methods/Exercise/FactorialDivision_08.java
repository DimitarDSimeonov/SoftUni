import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        double result = 1.0 * firstFactorial(first) / secondFactorial(second);
        System.out.printf("%.2f",result);
    }
    private static long firstFactorial (int one){
        long result = 1;
        for (int i = 1; i <= one ; i++) {
            result *= i;
        }
        return result;
    }
    private static long secondFactorial (int two){
        long result = 1;
        for (int i = 1; i <= two ; i++) {
            result *= i;
        }
        return result;
    }
}
