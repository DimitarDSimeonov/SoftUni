import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer ::parseInt).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.equals("end")){
            int num = 0;
            if (commands.contains("Contains")){
                num = Integer.parseInt(commands.split(" ")[1]);
                if (numbers.contains(num)){
                    System.out.println("Yes");
                }else {
                    System.out.println("No such number");
                }
            }else if (commands.contains("Print even")){
                List<Integer> evenNums = new ArrayList<>();
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0){
                        evenNums.add(numbers.get(i));
                    }
                }
                System.out.println(evenNums.toString().replaceAll("[\\[\\],]" ,""));
            }else if (commands.contains("Print odd")){
                List<Integer> oddNums = new ArrayList<>();
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0){
                        oddNums.add(numbers.get(i));
                    }
                }
                System.out.println(oddNums.toString().replaceAll("[\\[\\],]" , ""));
            }else if (commands.contains("Get sum")){
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);
            }else if (commands.contains("Filter")){
                num = Integer.parseInt(commands.split(" ")[2]);
                String condition = commands.split(" ")[1];
                if (condition.equals("<")){
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < num){
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }else if (condition.equals("<=")){
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= num){
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }else if (condition.equals(">")){
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > num){
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }else if (condition.equals(">=")){
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= num){
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            }



            commands = scanner.nextLine();
        }
    }
}
