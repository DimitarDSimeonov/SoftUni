package examPreparationMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Python_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int screenSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        int foodCount = 0;
        int pythonRow = 0;
        int pythonCol = 0;

        String[][] screen = new String[screenSize][screenSize];
        for (int row = 0; row < screenSize; row++) {
            String[] cols = scanner.nextLine().split(" ");
            for (int col = 0; col < cols.length; col++) {
                screen[row][col] = cols[col];
                if(cols[col].equals("s")) {
                    pythonRow = row;
                    pythonCol = col;
                }else if (cols[col].equals("f")) {
                    foodCount++;
                }
            }
        }
        int pythonLength = 1;
        boolean win = false;
        boolean killingByEnemy = false;

        for (String command : commands) {
            int nextRow = pythonRow;
            int nextCol = pythonCol;
            if (command.equals("up")) {
                if (pythonRow == 0) {
                    nextRow = screenSize - 1;
                }else {
                    nextRow = pythonRow - 1;
                }
                if (screen[nextRow][pythonCol].equals("f")) {
                    screen[nextRow][pythonCol] = "*";
                    foodCount--;
                    pythonLength++;
                    pythonRow = nextRow;
                    if(foodCount == 0) {
                        win = true;
                        break;
                    }
                }else if (screen[nextRow][pythonCol].equals("e")) {
                    killingByEnemy = true;
                    break;
                }else {
                    pythonRow = nextRow;
                }

            }else if (command.equals("down")) {
                if (pythonRow == screenSize - 1) {
                    nextRow = 0;
                }else {
                    nextRow = pythonRow + 1;
                }
                if (screen[nextRow][pythonCol].equals("f")) {
                    screen[nextRow][pythonCol] = "*";
                    foodCount--;
                    pythonLength++;
                    pythonRow = nextRow;
                    if(foodCount == 0) {
                        win = true;
                        break;
                    }
                }else if (screen[nextRow][pythonCol].equals("e")) {
                    killingByEnemy = true;
                    break;
                }else {
                    pythonRow = nextRow;
                }

            }else if (command.equals("left")) {
                if (pythonCol == 0) {
                    nextCol = screenSize - 1;
                }else {
                    nextCol = pythonCol - 1;
                }
                if (screen[pythonRow][nextCol].equals("f")) {
                    screen[pythonRow][nextCol] = "*";
                    pythonLength++;
                    foodCount--;
                    pythonCol = nextCol;
                    if (foodCount == 0) {
                        win = true;
                        break;
                    }
                }else if (screen[pythonRow][nextCol].equals("e")){
                    killingByEnemy = true;
                    break;
                }else {
                    pythonCol = nextCol;
                }

            }else if (command.equals("right")) {
                if(pythonCol == screenSize - 1) {
                    nextCol = 0;
                }else {
                    nextCol = pythonCol + 1;
                }
                if (screen[pythonRow][nextCol].equals("f")) {
                    screen[pythonRow][nextCol] = "*";
                    foodCount--;
                    pythonLength++;
                    pythonCol = nextCol;
                    if(foodCount == 0) {
                        win = true;
                        break;
                    }
                }else if (screen[pythonRow][nextCol].equals("e")) {
                    killingByEnemy = true;
                    break;
                }else {
                    pythonCol = nextCol;
                }

            }
        }
        if(win) {
            System.out.printf("You win! Final python length is %d%n", pythonLength);
        }else {
            if(killingByEnemy) {
                System.out.println("You lose! Killed by an enemy!");
            }else {
                System.out.printf("You lose! There is still %d food to be eaten.%n",foodCount);
            }
        }
    }
}
