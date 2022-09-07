import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int index = 0;

        while (!input.equals("Love!")){
            int range = Integer.parseInt(input.split(" ")[1]);
            index += range;
            if (index >= houses.length){
                index = 0;
            }
            if (houses[index] > 2){
                houses[index] -= 2;
            }else if (houses[index] == 2){
                houses[index] -= 2;
                System.out.printf("Place %d has Valentine's day.%n",index);
            }else {
                System.out.printf("Place %d already had Valentine's day.%n",index);
            }


            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n",index);
        int fails = 0;
        for (int e : houses){
            if (e > 0){
                fails++;
            }
        }
        if (fails == 0){
            System.out.println("Mission was successful.");
        }else {
            System.out.printf("Cupid has failed %d places.",fails);
        }
    }
}
