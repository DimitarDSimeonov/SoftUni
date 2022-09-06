import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputWords = scanner.nextLine().split(" ");
        Map<String, Integer> words = new LinkedHashMap<>();

        for (int i = 0; i < inputWords.length; i++) {
            String word = inputWords[i].toLowerCase();

            if (!words.containsKey(word)){
                words.put(word , 1);
            }else {
                int currentCount = words.get(word);
                words.put(word ,currentCount + 1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if(entry.getValue() % 2 != 0){
                oddWords.add(entry.getKey());
            }
        }
        for (int i = 0; i < oddWords.size(); i++) {
            System.out.print(oddWords.get(i));
            if (i < oddWords.size() - 1){
                System.out.print(", ");
            }
        }

    }
}

