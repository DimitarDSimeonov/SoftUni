package stackAndQueuesExercise;

import java.util.*;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberCommands; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(input[0] == 1){
                numbers.push(input[1]);

            }else if(input[0] == 2 && !numbers.isEmpty()){
                numbers.pop();

            }else if(input[0] == 3 && !numbers.isEmpty()){

                System.out.println(Collections.max(numbers));

            }
        }

    }
}
