package stackAndQueuesLab;

import java.util.*;
import java.util.stream.Collectors;


public class SimpleCalculator_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());


        while (list.size() > 1){
            int firstNum = Integer.parseInt(list.get(0));
            int secondNum = Integer.parseInt(list.get(2));
            String operator = list.get(1);

            int result = 0;

            if (operator.equals("+")){
                result = firstNum + secondNum;
            }else if (operator.equals("-")){
                result = firstNum - secondNum;
            }
            list.remove(0);
            list.remove(0);
            list.remove(0);
            list.add(0, result + "");

        }


        System.out.println(list.get(0));

    }
}
