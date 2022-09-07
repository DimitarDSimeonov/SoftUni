import java.util.Arrays;
import java.util.Scanner;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            int currentPeople = lift[i];
            if (currentPeople <= 4){
                int difference = 4 - currentPeople;

                if (difference <= people) {
                    lift[i] = currentPeople + difference;
                    people -= difference;
                }else{
                    lift[i] = currentPeople + people;
                    people -= difference;
                }
                if ( people < 0){
                    break;
                }
            }

        }
        if (people < 0){
            System.out.printf("The lift has empty spots!%n");
            printLift(lift);
        }else if (people == 0) {
            printLift(lift);
        }else{
            System.out.printf("There isn't enough space! %d people in a queue!%n", Math.abs(people));
            printLift(lift);
        }
    }
    public static void printLift (int [] lift){
        for ( int element : lift){
            System.out.print(element + " ");
        }
    }
}
