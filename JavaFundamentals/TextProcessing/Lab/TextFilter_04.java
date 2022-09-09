import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : banWords){
            if (text.contains(word)){
                text = text.replace(word, replaceString("*", word.length()));
            }
        }

        System.out.println(text);
    }
    public static String replaceString (String s, int count){
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
