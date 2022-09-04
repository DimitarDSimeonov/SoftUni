import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inpute = scanner.nextLine();
        double money = 0;

        while (!inpute.equals("Start")){
            double coin = Double.parseDouble(inpute);
            //0.1, 0.2, 0.5, 1, and 2 coins.
            if (coin == 2){
                money = money + coin;
            }else if (coin == 1){
                money = money + coin;
            }else if (coin == 0.5){
                money = money + coin;
            }else if (coin == 0.2){
                money = money + coin;
            }else if (coin == 0.1){
                money = money + coin;
            }else {
                System.out.printf("Cannot accept %.2f%n",coin);
            }
            inpute = scanner.nextLine();
        }
        inpute = scanner.nextLine();
        //"Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0
        while (!inpute.equals("End")){
            String product = inpute;

            if (product.equals("Nuts")){
                if(money >= 2){
                  money = money - 2;
                    System.out.println("Purchased Nuts");
                }else {
                    System.out.println("Sorry, not enough money");
                }
            }else if (product.equals("Water")){
                if (money>= 0.7){
                    money = money - 0.7;
                    System.out.println("Purchased Water");
                }else {
                    System.out.println("Sorry, not enough money");
                }
            }else if (product.equals("Crisps")){
                if (money >= 1.5){
                    money = money - 1.5;
                    System.out.println("Purchased Crisps");
                }else {
                    System.out.println("Sorry, not enough money");
                }
            }else if (product.equals("Soda")){
                if (money>= 0.8){
                    money = money - 0.8;
                    System.out.println("Purchased Soda");
                }else{
                    System.out.println("Sorry, not enough money");
                }
            }else if (product.equals("Coke")){
                if (money >= 1){
                    money = money - 1;
                    System.out.println("Purchased Coke");
                }else{
                    System.out.println("Sorry, not enough money");
                }
            }else {
                System.out.println("Invalid product");
            }
            inpute = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",money);
    }
}
