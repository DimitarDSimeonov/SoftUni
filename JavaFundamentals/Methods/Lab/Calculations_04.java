import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (action){
            case "add":
                System.out.println( add(a, b));
                break;
            case "multiply":
                System.out.println(multiply(a, b));
                break;
            case "subtract":
                System.out.println(subtract(a, b));
                break;
            case "divide":
                System.out.println(divide(a, b));
                break;
        }

    }

    private static int add (int a, int b){
        return  a + b;
    }

    private static int multiply ( int a, int b){
        return a * b;
    }

    private static int subtract (int a, int b){
        return a - b;
    }

    private static int divide (int a, int b){
        return a / b;
    }
}
