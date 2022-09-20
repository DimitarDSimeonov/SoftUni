package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean isBalanced = false;


        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openBrackets.push(currentBracket);

            } else {
                if (!openBrackets.isEmpty()) {
                    char lastBracket = openBrackets.pop();

                    if (lastBracket == '(' && currentBracket == ')' || lastBracket == '[' && currentBracket == ']' ||
                            lastBracket == '{' && currentBracket == '}') {
                        isBalanced = true;

                    } else {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
