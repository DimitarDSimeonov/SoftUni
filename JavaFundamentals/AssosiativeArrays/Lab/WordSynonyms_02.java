import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map< String, List<String> > wordMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordMap.containsKey(word)){
                wordMap.put(word , new ArrayList<>());
                wordMap.get(word).add(synonym);
            }else {
                wordMap.get(word).add(synonym);
            }
        }

        for (Map.Entry<String, List<String>> entry : wordMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue().toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
