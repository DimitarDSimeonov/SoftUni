import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e-> Integer.parseInt(e)).toArray();
        int result = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= array.length - 1; i++) {
            int firstNum = array[i];

            for (int j = i + 1; j <= array.length - 1 ; j++) {
                int secondNum = array[j];

                if (firstNum + secondNum == result){
                    System.out.println( firstNum + " " + secondNum);
                }
            }
        }
    }
}
