import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(numPower(num, power)));

    }

    private static double numPower ( double num, int power){
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= num;
        }
        return result;
    }
}
