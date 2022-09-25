package setsAndmapsAdvanceLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();
        Set<String> guestList = new TreeSet<>();

        while (!guest.equals("PARTY")){

            guestList.add(guest);

            guest = scanner.nextLine();
        }

        String comingGuest = scanner.nextLine();

        while (!comingGuest.equals("END")){

            guestList.remove(comingGuest);

            comingGuest = scanner.nextLine();
        }
        System.out.println(guestList.size());
        guestList.forEach(e -> System.out.println(e));
    }
}
