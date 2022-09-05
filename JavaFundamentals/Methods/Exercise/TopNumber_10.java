import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            int num = i;
            if (isValidOneDigitIsOdd(num) && isValitSumOfDigits(num)){
                System.out.println(num);
            }
        }

    }

    private static boolean isValitSumOfDigits(int n) {
        int sumOfDigit = 0;
        while (n > 0) {
            int digit = n % 10;
                sumOfDigit += digit;
                n /= 10;
        }
        if (sumOfDigit % 8 == 0) {
                return true;
        }else {
            return false;
        }
    }
    private static boolean isValidOneDigitIsOdd (int n){
        while (n > 0){
            int digit = n % 10;
            if (digit % 2 != 0){
                return true;
            }
            n /=10;
        }
        return false;
    }
}
