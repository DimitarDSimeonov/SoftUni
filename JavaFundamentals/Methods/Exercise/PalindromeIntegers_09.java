import java.util.Scanner;
import java.text.BreakIterator;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            StringBuilder sb = new StringBuilder();
            String nums = input;
            String reversed = sb.append(nums).reverse().toString();
            if (nums.equals(reversed)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

            input= scanner.nextLine();
        }
    }
}
