import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
        boolean notEquals = false;

        for (int index = 0; index <= inArray.length-1 ; index++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < index ; i++) {
                leftSum += inArray[i];
            }

            for (int i = index + 1; i < inArray.length ; i++) {
                rightSum += inArray[i];
            }

            if (leftSum == rightSum){
                System.out.println(index);
                notEquals = false;
                break;
            }else{
                notEquals = true;
            }

        }
        if (notEquals){
            System.out.println("no");
        }
    }
}
