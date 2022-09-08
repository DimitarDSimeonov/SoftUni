import java.util.*;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] racers = scanner.nextLine().split(", ");
        Map<String, Integer> racerResult = new LinkedHashMap<>();
        for (String racer : racers){
            racerResult.put(racer, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")){
            StringBuilder racerName = new StringBuilder();
            int distance = 0;
            for (int index = 0; index < input.length(); index++) {
                char currentChar = input.charAt(index);

                if(Character.isLetter(currentChar)){
                    racerName.append(currentChar);

                }else if (Character.isDigit(currentChar)){
                    distance += Integer.parseInt(currentChar + "");

                }
            }
            String name = racerName.toString();
            if(racerResult.containsKey(name)){
                int currentResult = racerResult.get(name);
                racerResult.put(name,currentResult + distance);
            }


            input = scanner.nextLine();
        }

        List<String> firstThree = racerResult.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3)
                .map(entry -> entry.getKey()).collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));
    }
}
