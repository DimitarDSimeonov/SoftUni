import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> result = new LinkedHashMap<>();
        Map<String, Integer> submission = new LinkedHashMap<>();

        while (!input.equals("exam finished")){
            String name = input.split("-")[0];
            String language = input.split("-")[1];

            if(language.equals("banned")){
                result.remove(name);
            }else{
                int points = Integer.parseInt(input.split("-")[2]);
                if(!result.containsKey(name)){
                    result.put(name, points);
                }else{
                    int currentPoint = result.get(name);
                    if(points > currentPoint){
                        result.put(name, points);
                    }
                }
                if (!submission.containsKey(language)){
                    submission.put(language , 1);
                }else{
                    int currentCount = submission.get(language);
                    submission.put(language, currentCount + 1);
                }
            }


            input = scanner.nextLine();
        }
        if (!result.isEmpty()){
            System.out.println("Results:");
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.printf("%s | %d%n",entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submission.entrySet()) {
            System.out.printf("%s - %d%n",entry.getKey(), entry.getValue());
        }


    }
}
