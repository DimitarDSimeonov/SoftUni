package setsAndmapsAdvanceLab;

import com.sun.security.jgss.GSSUtil;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")){

            String command = input.split(", ")[0];
            String registration = input.split(", ")[1];

            if(command.equals("IN")){
                carNumbers.add(registration);

            }else if(command.equals("OUT")){
                carNumbers.remove(registration);
            }

            input = scanner.nextLine();
        }
        if(carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            carNumbers.forEach(e -> System.out.println(e));
        }
    }
}
