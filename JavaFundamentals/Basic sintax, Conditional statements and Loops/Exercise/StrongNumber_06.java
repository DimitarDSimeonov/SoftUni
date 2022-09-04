import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int num = number;
        int sumFact = 0;

        while (num>0){
            int digit = num % 10;
            num = num /10;
            int fact = 1;

            for (int i = 1; i <= digit ; i++) {
                fact = fact * i;
            }
            sumFact += fact;
        }
        if (number == sumFact){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
