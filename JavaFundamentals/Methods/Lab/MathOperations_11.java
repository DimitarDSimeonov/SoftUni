import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firsNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(operation(firsNum, operator, secondNum)));


    }

    private static double operation (int a, String operator, int b){
        double result = 0;
        switch (operator){
            case "+":
                result = a + b;
                break;
            case "-":
                result =  a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }
        return result;
    }
}
