import tasks.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //ТЕСТВАНЕТО НА 6-ТА МОЖЕ ДА СЧУПИ БАЗАТА ЗА РЕШЕНИЕТО НА 7-МА
        //Before start place set your user and password in persistence.xml
        //Проверяващия колега трябва да пусне веднъж проекта за да се създаде базата данни,
        // да го спре и да я попълни от SQL файла и пак да пусне за тестване на задачите
        Manager.run();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are we going to test the task?[YES/NO]");
        String input = scanner.nextLine().toUpperCase(Locale.ROOT);

        while (!input.equals("NO")) {

            System.out.println("Enter the number of task[2-13]");
            input = scanner.nextLine();

            switch (input) {
                case "2" -> ChangeCasing.run();
                case "3" -> ContainsEmployee.run();
                case "4" -> EmployeesWhitSalaryOver50000.run();
                case "5" -> EmployeesFromDepartment.run();
                case "6" -> AddingNewAddressAndUpdatingEmployee.run();
                case "7" -> AddressesWhitEmployeeCount.run();
                case "8" -> GetEmployeesWhitProject.run();
                case "9" -> FindTheLatest10Projects.run();
                case "10" -> IncreaseSalaries.run();
                case "11" -> FindEmployeesByFirstName.run();
                case "12" -> EmployeesMaximumSalaries.run();
                case "13" -> RemoveTowns.run();
            }

            System.out.println("Other task?[YES/NO]");
            input = scanner.nextLine().toUpperCase(Locale.ROOT);
        }
        System.out.println("Have a nice day!");
    }
}
