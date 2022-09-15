package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> result = new ArrayDeque<>();

        if(input == 0){
            result.push(0);
        }else{
            while (input > 0){
                result.push(input % 2);
                input /= 2;
            }
        }

        while (!result.isEmpty()){
            System.out.print(result.pop());
        }
    }
}
