import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e-> Integer.parseInt(e)).toArray();

        int length = 1;
        int maxLength = 0;
        int startIndex = 0;
        int bestStartIndex = 0;

        for (int i = 1; i <= numArray.length -1; i++) {

            if (numArray[i] == numArray[i - 1]){
                length++;
            }else{
                length = 1;
                startIndex = i;
            }

            if (length > maxLength){
                maxLength = length;
                bestStartIndex = startIndex;
            }
        }

        for (int i = bestStartIndex; i < bestStartIndex + maxLength ; i++) {
            System.out.print(numArray[i] + " ");
        }
    }
}
