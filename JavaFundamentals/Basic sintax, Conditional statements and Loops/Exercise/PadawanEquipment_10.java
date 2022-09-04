import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
        //•	The count of students – integer in the range [0…100].
        //•	The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
        //•	The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
        //•	The price of belts for a single belt – the floating-point number in the range [0.00…100.00].
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceForLightsabre = Double.parseDouble(scanner.nextLine());
        double priceForRobe = Double.parseDouble(scanner.nextLine());
        double priceForBelt = Double.parseDouble(scanner.nextLine());

        double lightsabre = Math.ceil(students * 1.1)* priceForLightsabre;
        double robe = students * priceForRobe;
        double belt = students * priceForBelt - (students/6 * priceForBelt);
        double totalPrice = lightsabre + robe + belt;

        double diff = Math.abs(totalPrice- money);

        if (money >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else {
            System.out.printf("George Lucas will need %.2flv more.",diff);
        }
    }
}
