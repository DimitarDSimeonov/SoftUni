import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int startNum = Integer.parseInt(scanner.nextLine());

        if (startNum > 10) {
            System.out.printf("%d X %d = %d", num, startNum, num * startNum);
        } else {
            for (int i = startNum; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", num, i, num * i);

            }
        }
    }
}