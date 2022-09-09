import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String partString = scanner.nextLine();
        String text =scanner.nextLine();

        while (text.contains(partString)){
            text = text.replace(partString, "");
        }
        System.out.println(text);
    }
}
