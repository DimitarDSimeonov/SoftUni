import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

        if (day.equals("Friday")){
            if (typeGroup.equals("Students")){
                price = peopleInGroup * 8.45;
                if (peopleInGroup >= 30){
                    price = price * 0.85;
                }
            }else if (typeGroup.equals("Business")){
                price = peopleInGroup * 10.90;
                if (peopleInGroup >= 100){
                    price = (peopleInGroup-10) * 10.90;
                }
            }else if (typeGroup.equals("Regular")){
                  price = peopleInGroup * 15.00;
                  if (peopleInGroup >= 10 && peopleInGroup <= 20){
                      price = price * 0.95;
                  }
            }

        }else if (day.equals("Saturday")){
            if (typeGroup.equals("Students")){
                price = peopleInGroup * 9.80;
                if (peopleInGroup >= 30) {
                    price = price * 0.85;
                }
            }else if (typeGroup.equals("Business")){
                price = peopleInGroup * 15.60;
                if (peopleInGroup >= 100){
                    price = (peopleInGroup-10) * 15.60;
                }
            }else if (typeGroup.equals("Regular")){
                price = peopleInGroup * 20.00;
                if (peopleInGroup >= 10 && peopleInGroup <= 20){
                    price = price * 0.95;
                }
            }
         }else if (day.equals("Sunday")){
            if (typeGroup.equals("Students")){
                price = peopleInGroup * 10.46;
                if (peopleInGroup >= 30) {
                    price = price * 0.85;
                }
            }else if (typeGroup.equals("Business")){
                price = peopleInGroup * 16.00;
                if (peopleInGroup >= 100){
                    price = (peopleInGroup-10) * 16.00;
                }
            }else if (typeGroup.equals("Regular")){
                price = peopleInGroup * 22.50;
                if (peopleInGroup >= 10 && peopleInGroup <= 20){
                    price = price * 0.95;
                }
            }
        }
        System.out.printf("Total price: %.2f",price);
    }
}
