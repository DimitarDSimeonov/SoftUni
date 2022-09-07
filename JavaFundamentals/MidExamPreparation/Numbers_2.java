import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_2 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Finish")){
            String command = input.split(" ")[0];
            int value = Integer.parseInt(input.split(" ")[1]);

            switch (command){
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    int index = numbers.indexOf(value);
                    numbers.remove(index);
                    break;
                case "Replace":
                    int newValue = Integer.parseInt(input.split(" ")[2]);

                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i).equals(value)){
                            numbers.set(i , newValue);
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < value){
                            numbers.remove(i);
                            i = -1;
                        }
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int element : numbers){
            System.out.print(element + " ");
        }
    }
}
