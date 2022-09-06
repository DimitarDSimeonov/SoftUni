import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String operation = scanner.nextLine();

        while (!operation.equals("course start")){
            String commands = operation.split(":")[0];
            String lessonName = operation.split(":")[1];

            if (commands.equals("Add")){
                if (!lessons.contains(lessonName)){
                    lessons.add(lessonName);
                }

            }else if (commands.equals("Insert")){
                int index = Integer.parseInt(operation.split(":")[2]);
                if (isValidIndex(index, lessons.size()) && !lessons.contains(lessonName)){
                    lessons.add(index , lessonName);
                }

            }else if (commands.equals("Remove")){
                if (lessons.contains(lessonName)) {
                    lessons.remove(lessonName);
                    if(lessons.contains(lessonName + "-Exercise")){
                        lessons.remove(lessonName + "Exercise");
                    }
                }

            }else if (commands.equals("Swap")){
                String secondLessonName = operation.split(":")[2];
                if (lessons.contains(lessonName) && lessons.contains(secondLessonName)){
                    int firstLessonIndex = lessons.indexOf(lessonName);
                    int secondLessonIndex = lessons.indexOf(secondLessonName);
                    lessons.set(firstLessonIndex, secondLessonName);
                    lessons.set(secondLessonIndex, lessonName);

                    String firstExercise = lessonName + "-Exercise";
                    String secondExercise = secondLessonName + "-Exercise";
                    if(lessons.contains(firstExercise)){
                        lessons.remove(lessons.indexOf(firstExercise));
                        lessons.add(secondLessonIndex + 1, firstExercise);
                    }
                    if (lessons.contains(secondExercise)){
                        lessons.remove(lessons.indexOf(secondExercise));
                        lessons.add(firstLessonIndex + 1, secondExercise);
                    }
                }

            }else if (commands.equals("Exercise")){
                String exercise = lessonName + "-Exercise";
                int indexLessonName = lessons.indexOf(lessonName);
                if (lessons.contains(lessonName)) {
                    if (indexLessonName == lessons.size() - 1) {
                        lessons.add(indexLessonName + 1, exercise);
                    } else if (!lessons.get(indexLessonName + 1).equals(exercise)){
                        lessons.add(indexLessonName + 1, exercise);
                    }
                }else {
                    lessons.add(lessonName);
                    lessons.add(exercise);
                }
            }



            operation = scanner.nextLine();
        }

        for (int i = 0; i < lessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }
    }
    public static boolean isValidIndex (int index, int size){
        return index >= 0 && index < size;
    }
}
