package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> index = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '('){
                index.push(i);
            }else if(symbol == ')'){
                int startIndex = index.pop();
                int endIndex = i;
                System.out.println(input.substring(startIndex, endIndex + 1));
            }
        }
    }
}
