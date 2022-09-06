import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String currentCourse = input.split(" : ")[0];
            String name = input.split(" : ")[1];

            if (!courses.containsKey(currentCourse)) {
                courses.put(currentCourse, new ArrayList<>());
                courses.get(currentCourse).add(name);

            } else {
                courses.get(currentCourse).add(name);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n",entry.getValue().get(i));
            }
        }

    }
}

