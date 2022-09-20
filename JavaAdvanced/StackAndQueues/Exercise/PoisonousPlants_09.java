package stackAndQueuesExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer :: parseInt).collect(Collectors.toList());
        int days = 0;

        while (true){
            boolean plantsStopDie = true;
            for (int index = plants.size()-1; index >= 1 ; index--) {
                if (plants.get(index) > plants.get(index-1)){
                    plants.remove(index);
                    plantsStopDie = false;
                }
            }
            if(plantsStopDie){
                break;
            }
            days++;
        }
        System.out.println(days);
    }
}
