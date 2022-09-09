import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] texts = scanner.nextLine().split(" ");
        StringBuilder repeatTexts = new StringBuilder();

        for (String text : texts){
            for (int i = 0; i < text.length(); i++) {
                repeatTexts.append(text);
            }
        }
        System.out.println(repeatTexts);
    }
}
