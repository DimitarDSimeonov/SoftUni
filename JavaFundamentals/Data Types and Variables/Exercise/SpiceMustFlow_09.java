import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int source = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalSpice = 0;

        while (source >= 100){
            days++;
            totalSpice += source - 26;
            source -= 10;
        }
        if (totalSpice >= 26){
            totalSpice -= 26;
        }
        System.out.println(days);
        System.out.println(totalSpice);
    }
}
