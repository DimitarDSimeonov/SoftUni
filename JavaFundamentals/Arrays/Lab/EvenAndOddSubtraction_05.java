import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e ->Integer.parseInt(e)).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int num : numbers){
            if(num % 2 == 0){
                evenSum += num;
            }else{
                oddSum += num;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
