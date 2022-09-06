import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList =Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        //Add {number}: add a number to the end of the list
        //Remove {number}: remove a number from the list
        //RemoveAt {index}: remove a number at a given index
        //Insert {number} {index}: insert a number at a given index

        while (!input.equals("end")){
            String command = input.split(" ")[0];
            int num = 0;
            int index = 0;

            switch (command){
                case "Add":
                    num = Integer.parseInt(input.split(" ")[1]);
                    numList.add(num);
                    break;

                case "Remove":
                    num = Integer.parseInt(input.split(" ")[1]);
                    numList.removeAll(Collections.singleton(num));
                    break;

                case "RemoveAt":
                    index = Integer.parseInt(input.split(" ")[1]);
                    numList.remove(index);
                    break;

                case "Insert":
                    num = Integer.parseInt(input.split(" ")[1]);
                    index = Integer.parseInt(input.split(" ")[2]);
                    numList.add(index, num);
                    break;
            }


            input = scanner.nextLine();
        }
        for (int ele : numList){
            System.out.print(ele + " ");
        }
    }
}
