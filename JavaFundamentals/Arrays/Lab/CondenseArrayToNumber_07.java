import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e ->Integer.parseInt(e)).toArray();

        while (inArr.length > 1){
            int[] condesedArr = new int[inArr.length -1];
            for (int j = 0; j < inArr.length-1; j++) {
            condesedArr[j] = inArr[j] + inArr[j +1];
            }

            inArr = condesedArr;

        }
        System.out.println(inArr[0]);
    }
}
