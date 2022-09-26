package setsAndmapsAdvanceLab;

import java.util.*;

public class CountRealNumbers_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> countNumbers = new LinkedHashMap<>();

        for (Double num : numbers) {

            countNumbers.putIfAbsent(num , 0);
            countNumbers.put(num, countNumbers.get(num) + 1);
        }

        for (Map.Entry<Double, Integer> entry : countNumbers.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(), entry.getValue());
        }

    }
}
