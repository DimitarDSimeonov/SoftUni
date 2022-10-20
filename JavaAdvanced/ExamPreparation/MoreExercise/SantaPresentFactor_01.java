package examPreparationMoreExercise;

import java.util.*;

public class SantaPresentFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> materialStack.push(e));

        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> magicLevelQueue.offer(e));

        int doll = 0;
        int woodenTrain = 0;
        int teddyBear = 0;
        int bicycle = 0;

        while (!magicLevelQueue.isEmpty() && !materialStack.isEmpty()) {
            int material = materialStack.peek();
            int magic = magicLevelQueue.peek();

            if (material == 0){
                materialStack.pop();
            }
            if (magic == 0) {
                magicLevelQueue.poll();
            }

            int sum = material * magic;

            if(sum == 150) {
                doll++;
                materialStack.pop();
                magicLevelQueue.poll();

            }else if (sum == 250) {
                woodenTrain++;
                materialStack.pop();
                magicLevelQueue.poll();

            }else if (sum == 300) {
                teddyBear++;
                materialStack.pop();
                magicLevelQueue.poll();

            }else if (sum == 400) {
                bicycle++;
                materialStack.pop();
                magicLevelQueue.poll();

            }else {
                if(sum < 0) {
                    materialStack.pop();
                    magicLevelQueue.poll();
                    sum = material + magic;
                    materialStack.push(sum);

                }else if (sum > 0) {
                    magicLevelQueue.poll();
                    material += 15;
                    materialStack.pop();
                    materialStack.push(material);
                }

            }
        }
        Map<String, Integer> toys = new TreeMap<>();
        toys.put("Doll: ",doll);
        toys.put("Wooden train: ", woodenTrain);
        toys.put("Teddy bear: ", teddyBear);
        toys.put("Bicycle: ", bicycle);

        if ((doll > 0 && woodenTrain > 0) || (teddyBear > 0 && bicycle > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialStack.isEmpty()){
            System.out.println("Materials left: " + String.join(", ", String.valueOf(materialStack).replaceAll("[\\[\\]]", "")));
        }
        if (!magicLevelQueue.isEmpty()) {
            System.out.println("Magic left: " + String.join(", ", String.valueOf(magicLevelQueue).replaceAll("[\\[\\]]","")));
        }
        for (Map.Entry<String, Integer> entry : toys.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + entry.getValue());
            }
        }
    }
}
