package setsAndmapsAdvanceLab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < line; i++) {
            String name = scanner.nextLine();
            List<Double> gradesList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

            studentsGrades.put(name,gradesList);
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            double sumOfGrade = 0;
            for(Double g : entry.getValue()){
                sumOfGrade += g;
            }
            DecimalFormat format = new DecimalFormat("#.###########################");
            System.out.println(entry.getKey() + " is graduated with " + format.format(sumOfGrade/entry.getValue().size()) );
        }

    }
}
