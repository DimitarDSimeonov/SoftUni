import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")){
            //•	Add {number} - add number at the end
            //•	Insert {number} {index} - insert number at given index
            //•	Remove {index} - remove that index
            //•	Shift left {count} - first number becomes last 'count' times
            //•	Shift right {count}- last number becomes first 'count' times
            int num = 0;
            int index = 0;
            int count = 0;
            if (command.contains("Add")){
                num = Integer.parseInt(command.split(" ")[1]);
                numbers.add(num);

            }else if (command.contains("Insert")){
                num = Integer.parseInt(command.split(" ")[1]);
                index = Integer.parseInt(command.split(" ")[2]);
                if(isValidIndex(index, numbers.size())){
                    numbers.add(index, num);
                }else {
                    System.out.println("Invalid index");
                }

            }else if (command.contains("Remove")){
                index = Integer.parseInt(command.split(" ")[1]);
                if (isValidIndex(index, numbers.size())){
                    numbers.remove(index);
                }else {
                    System.out.println("Invalid index");
                }

            }else if (command.contains("Shift left")){
                count = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < count; i++) {
                    int currentNum = numbers.get(0);
                    numbers.add(currentNum);
                    numbers.remove(0);
                }
            }else if (command.contains("Shift right")){
                count = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < count; i++) {
                    int currentNum = numbers.get(numbers.size() - 1);
                    numbers.add(0 , currentNum);
                    numbers.remove(numbers.size() - 1);
                }
            }


            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
    public static boolean isValidIndex (int index , int size){
        return index >= 0 && index <= size - 1;
    }
}
