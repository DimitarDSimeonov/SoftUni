import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")){
            int element = Integer.parseInt(command.split(" ")[1]);
            if (command.contains("Delete")){
                numbers.removeAll(Collections.singleton(element));

            }else if (command.contains("Insert")){
                int index = Integer.parseInt(command.split(" ")[2]);
                numbers.add( index, element);
            }



            command = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
