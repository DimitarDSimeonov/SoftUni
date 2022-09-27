package setsAndmapsAdvanceLab;

import java.util.*;

public class AverageStudentsGrades_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 0; i < lines; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if(!studentsGrades.containsKey(name)){
                studentsGrades.put(name , new ArrayList<>());
                studentsGrades.get(name).add(grade);
            }else{
                studentsGrades.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            double gradeSum = 0;
            System.out.print(entry.getKey() + " -> ");

            for (double grade : entry.getValue()){
                gradeSum += grade;
                System.out.printf("%.2f ",grade);
            }
            System.out.printf("(avg: %.2f)",gradeSum/entry.getValue().size());
            System.out.println();

        }

    }
}
