import java.util.*;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(!students.containsKey(name)){
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            }else{
                students.get(name).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double gradeSum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                gradeSum += entry.getValue().get(i);
            }
            double averageGrade = gradeSum/entry.getValue().size();
            if(averageGrade >= 4.50){
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }

    }
}
