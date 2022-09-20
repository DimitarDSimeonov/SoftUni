package stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOperations = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> undoCommand = new ArrayDeque<>();

        for (int i = 0; i < numberOperations; i++) {
            String[] commands = scanner.nextLine().split(" ");

            switch (commands[0]){
                case "1":
                    undoCommand.push(text);
                    text += commands[1];
                    break;
                case "2":
                    undoCommand.push(text);
                    int elementsToRemove = Integer.parseInt(commands[1]);
                    text = text.substring(0, text.length() - elementsToRemove);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    text = undoCommand.pop();
                    break;
            }
        }
    }
}
