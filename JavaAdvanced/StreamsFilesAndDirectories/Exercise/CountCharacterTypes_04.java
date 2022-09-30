package streamsFilesAndDirectoriesExercise;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes_04 {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("resources/input.txt");
        PrintWriter pr = new PrintWriter("resources/output.txt");

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        int oneByte = fr.read();

        while (oneByte > 0){
            char symbol = (char) oneByte;

            if(isVowels(symbol)){
                vowels++;

            }else if (isPunctuation(symbol)){
                punctuation++;

            }else if (!Character.isWhitespace(symbol)){
                consonants++;
            }


            oneByte = fr.read();
        }
        fr.close();
        pr.println("Vowels: " + vowels);
        pr.println("Consonants: " + consonants);
        pr.println("Punctuation: " + punctuation);
        pr.close();

    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '.' || symbol == ',' || symbol == '?' || symbol == '!';
    }

    private static boolean isVowels(char symbol) {
        return symbol == 'a' || symbol == 'o' || symbol == 'i' || symbol == 'u' || symbol == 'e';
    }
}
