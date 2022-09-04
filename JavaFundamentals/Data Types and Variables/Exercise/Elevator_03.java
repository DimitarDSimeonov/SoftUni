import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        double courses = (Math.ceil(1.0 * numberOfPeople / capacity));
        System.out.printf("%.0f",courses);
    }
}
