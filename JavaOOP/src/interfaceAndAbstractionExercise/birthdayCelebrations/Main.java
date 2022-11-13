package interfaceAndAbstractionExercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Birthable> list = new ArrayList<>();

        while (!"End".equals(input[0])) {

            switch (input[0]) {
                case "interfaceAndAbstractionExercise.birthdayCelebrations.interfaceAndAbstractionExercise.foodShortage.Citizen":
                    String name = input[1];
                    int age = Integer.parseInt(input[2]);
                    String id = input[3];
                    String birthdate = input[4];
                    list.add(new Citizen(name, age, id, birthdate));
                    break;

                case "interfaceAndAbstractionExercise.birthdayCelebrations.Pet":
                    String namePet = input[1];
                    String birthDate = input[2];
                    list.add(new Pet(namePet, birthDate));
                    break;
                case "interfaceAndAbstractionExercise.birthdayCelebrations.Robot":
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        String year = scanner.nextLine();
        boolean noOutput = true;

        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
                noOutput = false;
            }
        }

        if (noOutput) {
            System.out.println("<no output>");
        }
    }
}
