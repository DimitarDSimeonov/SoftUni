package examPreparationExercise;

import java.util.*;

public class LootBox_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(e -> firstQueue.offer(e));

        ArrayDeque<Integer> secondStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(e -> secondStack.push(e));

        List<Integer> list = new ArrayList<>();

        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {

            int first = firstQueue.peek();
            int second = secondStack.peek();

            if ((first + second) % 2 == 0) {
                list.add(first + second);
                firstQueue.poll();
                secondStack.pop();
            } else {
                secondStack.pop();
                firstQueue.offer(second);
            }
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();

        if(firstQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100){
            System.out.printf("Your loot was epic! Value: %d" ,sum);
        }else {
            System.out.printf("Your loot was poor... Value: %d" ,sum);
        }
    }
}
