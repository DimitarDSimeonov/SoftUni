import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")){
            StringBuilder sb = new StringBuilder(input);
            sb.reverse();
            System.out.printf("%s = %s%n",input, sb);

            input = scanner.nextLine();
        }
    }
}
