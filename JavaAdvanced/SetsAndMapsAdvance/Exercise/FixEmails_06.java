package setsAndMapsAdvaceExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> correctEmails = new LinkedHashMap<>();

        while (!name.equals("stop")){

            String email = scanner.nextLine();
            boolean validEmail = !email.endsWith(".uk") && !email.endsWith(".us") && !email.endsWith(".com");

            if(validEmail){
                correctEmails.put(name, email);
            }

            name = scanner.nextLine();
        }
        correctEmails.entrySet().forEach(e -> System.out.printf("%s -> %s%n",e.getKey(), e.getValue()));
    }
}
