import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] people = new int[n];
        int totalPeople = 0;

        for (int i = 0; i < people.length; i++) {
            int currentPeople = Integer.parseInt(scanner.nextLine());
            people[i] = currentPeople;
            totalPeople += currentPeople;
        }

        for (int p : people) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println(totalPeople);
    }
}
