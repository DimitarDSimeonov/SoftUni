import java.util.Scanner;

public class Orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        //o Price per capsule - floating-point number in range [0.00…1000.00]
        //
        //o Days – integer in range [1…31]
        //
        //o Capsules count - integer in range [0…2000]

        for (int i = 0; i < orders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double price = pricePerCapsule * days * capsulesCount;
            System.out.printf("The price for the coffee is: $%.2f%n",price);
            totalPrice = totalPrice + price;
        }
        System.out.printf("Total: $%.2f",totalPrice);
    }
}
