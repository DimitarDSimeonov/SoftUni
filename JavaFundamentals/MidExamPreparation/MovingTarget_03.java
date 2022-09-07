import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String command = input.split(" ")[0];
            int index = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            if (command.contains("Shoot") && isValidIndex(targets , index)){
                int power = Integer.parseInt(input.split(" ")[2]);
                int targetValue = targets.get(index);

                if (targetValue - power > 0){
                    targetValue -= power;
                    targets.set(index, targetValue);
                }else {
                    targets.remove(index);
                }

            }else if (command.contains("Add")) {
                if (isValidIndex(targets, index)) {
                    int value = Integer.parseInt(input.split(" ")[2]);
                    targets.add(index, value);
                } else {
                System.out.println("Invalid placement!");
                }

            }else if (command.contains("Strike") ){
                if (index - radius >= 0 && index + radius <= targets.size() -1) {
                    for (int i = index - radius; i <= index + radius; i++) {
                        targets.remove(index - radius);
                    }
                }else {
                    System.out.println("Strike missed!");
                }

            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));
            if (i < targets.size() - 1){
                System.out.print("|");
            }
        }
    }
    public static boolean isValidIndex (List<Integer> list , int index){
        return index >= 0 && index <= list.size()-1;
    }
}
