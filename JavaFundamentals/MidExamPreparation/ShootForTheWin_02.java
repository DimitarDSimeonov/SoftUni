import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int shootingTarget = 0;

        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if (index >= 0 && index < targets.length){
                int currentTarget = targets[index];
                if (currentTarget != -1){
                    targets[index] = -1;
                    shootingTarget++;
                    for (int i = 0; i < targets.length; i++) {
                        if (currentTarget < targets[i] && targets[i] != -1){
                            targets[i] -= currentTarget;
                        }else if (currentTarget >= targets[i] && targets[i] != -1) {
                            targets[i] += currentTarget;
                        }
                    }
                }
            }


            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",shootingTarget);
        for (int i = 0; i < targets.length; i++) {
            System.out.print(targets[i]);
            if (i < targets.length - 1){
                System.out.print(" ");
            }
        }
    }
}
