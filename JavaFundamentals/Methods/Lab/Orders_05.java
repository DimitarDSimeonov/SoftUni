import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printTotalPrice(product, quantity);

    }
    private static void printTotalPrice (String product, int quantity){
        //•	coffee – 1.50
        //•	water – 1.00
        //•	coke – 1.40
        //•	snacks – 2.00
        switch (product){
            case "coffee":
                System.out.printf("%.2f", quantity * 1.50);
                break;
            case "water":
                System.out.printf("%.2f", quantity * 1.00);
                break;
            case "coke":
                System.out.printf("%.2f", quantity * 1.40);
                break;
            case "snacks":
                System.out.printf("%.2f", quantity * 2.00);
        }
    }
}
