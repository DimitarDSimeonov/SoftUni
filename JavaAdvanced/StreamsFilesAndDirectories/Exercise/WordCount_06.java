package streamsFilesAndDirectoriesExercise;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount_06 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("resources/words.txt"));

        String[] searchingWords = scanner.nextLine().split(" ");
        Map<String, Integer> wordsCounter = new LinkedHashMap<>();

        for (String word : searchingWords){
            wordsCounter.put(word, 0);
        }

        Scanner fileScanner = new Scanner(new FileReader("resources/text.txt"));
        String word = fileScanner.next();
        while (fileScanner.hasNext()){

            if(wordsCounter.containsKey(word)){
                int currentCount = wordsCounter.get(word) + 1;
                wordsCounter.put(word, currentCount);
            }
            word = fileScanner.next();
        }

        PrintWriter pr = new PrintWriter("resources/result.txt");
        for (Map.Entry<String, Integer> entry : wordsCounter.entrySet()) {
            pr.println(entry.getKey() + " - " + entry.getValue());
        }
        pr.close();
        fileScanner.close();
        scanner.close();

    }
}
