import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        int result = multiplyEvenByOddSum(num);

        System.out.println(result);

    }
    private static int multiplyEvenByOddSum (int n){
        int evenSum = evenSum(n);
        int oddSum = oddSum(n);
        return evenSum * oddSum;
    }

    private static int oddSum (int n){
        int oddSum = 0;
        while ( n > 0){
            int digit = n % 10;
            if (digit % 2 != 0){
                oddSum += digit;
            }
            n /= 10;
        }
        return oddSum;

    }
    private static int evenSum (int n){
        int evenSum = 0;
        while (n > 0){
            int digit = n % 10;
            if(digit % 2 == 0){
                evenSum += digit;
            }
            n /= 10;
        }
        return evenSum;

    }

}
