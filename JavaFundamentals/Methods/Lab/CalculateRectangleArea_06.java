import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wight = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", area(wight,length));

    }

    private static double area (double wight, double length){
        return wight * length;
    }
}
