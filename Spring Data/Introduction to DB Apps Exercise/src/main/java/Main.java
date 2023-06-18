import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        //Before start place set your user and password in Connector

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are we going to test the task?[YES/NO]");
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);

        while (!input.equals("NO")) {

            System.out.println("Enter the number of task[2-9]");
            input = scanner.nextLine();

            switch (input) {
                case "2" -> GetVillainsNames.run();
                case "3" -> GetMinionNames.run();
                case "4" ->  AddMinion.run();
                case "5" -> ChangeTownNamesCasing.run();
                case "6" -> RemoveVillain.run();
            }

            System.out.println("Other task?[YES/NO]");
            input = scanner.nextLine().toUpperCase(Locale.ROOT);
        }
        System.out.println("Have a nice day!");

    }
}
