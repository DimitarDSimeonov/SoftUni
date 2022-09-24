package setsAndMapsAdvaceExercise;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();
        Map<String, String > phonebook = new HashMap<>();

        while (!info.equals("search")){

            String name = info.split("-")[0];
            String number = info.split("-")[1];

            phonebook.put(name, number);

            info = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("stop")){

            if(phonebook.containsKey(command)){
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            }else{
                System.out.printf("Contact %s does not exist.%n",command);
            }

            command = scanner.nextLine();
        }
    }
}
