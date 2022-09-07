import java.util.Arrays;
import java.util.Scanner;

public class TheAngryCat_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] priceRating = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entryPosition = Integer.parseInt(scanner.nextLine());  //входния индекс
        String typeItems = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        int num = priceRating[entryPosition];

        for (int i = 0; i < entryPosition; i++) {
            if (typeItems.equals("cheap")){
                if(priceRating[i] < num){
                    leftSum += priceRating[i];
                }
            }else if (typeItems.equals("expensive")){
                if (priceRating[i] >= num){
                    leftSum += priceRating[i];
                }
            }
        }

        for (int i = entryPosition + 1; i < priceRating.length; i++) {
            if (typeItems.equals("cheap")){
                if(priceRating[i] < num){
                    rightSum += priceRating[i];
                }
            }else if (typeItems.equals("expensive")){
                if (priceRating[i] >= num){
                    rightSum += priceRating[i];
                }
            }
        }

        if (leftSum >= rightSum){
            System.out.printf("Left - %d", leftSum);
        }else {
            System.out.printf("Right - %d", rightSum);
        }
    }
}
