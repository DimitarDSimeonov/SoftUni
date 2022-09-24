package setsAndMapsAdvaceExercise;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            symbols.putIfAbsent(currentChar, 0);
            symbols.put(currentChar, symbols.get(currentChar)+1);
        }
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
