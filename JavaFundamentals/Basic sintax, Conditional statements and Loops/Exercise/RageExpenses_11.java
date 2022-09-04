import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	On the first input line - lost games count – integer in the range [0, 1000].
        //•	On the second line – headset price - the floating-point number in the range [0, 1000].
        //•	On the third line – mouse price - the floating-point number in the range [0, 1000].
        //•	On the fourth line – keyboard price - the floating-point number in the range [0, 1000].
        //•	On the fifth line – display price - the floating-point number in the range [0, 1000].
        int lostGame = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double headset = (lostGame/2) * headsetPrice;
        double mouse = (lostGame/3) * mousePrice;
        double keyboard = (lostGame/6) * keyboardPrice;
        double display = (lostGame/12) * displayPrice;

        double totalPrice = headset + mouse + keyboard + display;

        System.out.printf("Rage expenses: %.2f lv.",totalPrice);
    }
}
