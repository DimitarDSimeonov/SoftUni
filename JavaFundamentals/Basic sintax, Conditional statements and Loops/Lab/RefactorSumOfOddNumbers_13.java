import java.util.Scanner;

public class RefactorSumOfOddNumbers_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int sum = n * n;

        for (int i = 0; i < n; i++) {

            System.out.println(2 * i + 1);
            //sum += 2 * i;
        }

        System.out.printf("Sum: %d%n", sum);
    }
}
