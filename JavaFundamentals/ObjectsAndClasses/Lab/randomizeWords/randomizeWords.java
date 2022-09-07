package randomizeWords;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        while (wordList.size() > 0){
            Random rdn = new Random();
            int randomIndex = rdn.nextInt(wordList.size());

            String word = wordList.get(randomIndex);
            System.out.println(word);

            wordList.remove(randomIndex);
        }
    }
}
