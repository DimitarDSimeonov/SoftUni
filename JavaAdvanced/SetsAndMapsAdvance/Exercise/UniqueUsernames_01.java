package setsAndMapsAdvaceExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());
        Set<String> users = new LinkedHashSet<>();

        for (int in = 0; in < line; in++) {
            String user = scanner.nextLine();
            users.add(user);
        }

        for (String user : users){
            System.out.println(user);
        }
    }
}
