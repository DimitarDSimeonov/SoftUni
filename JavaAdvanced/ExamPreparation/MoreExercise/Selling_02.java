package examPreparationMoreExercise;

import java.util.Scanner;

public class Selling_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = new char[size][size];

        int positionRow = 0;
        int positionCol = 0;

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                bakery[row][col] = input.charAt(col);
                if(bakery[row][col] == 'S') {
                    positionRow = row;
                    positionCol = col;
                }
            }
        }

        int money = 0;

        while (money < 50) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                if(positionRow == 0) {
                    bakery[positionRow][positionCol] = '-';
                    break;

                }else if(Character.isDigit(bakery[positionRow - 1][positionCol])) {
                    int current = Integer.parseInt(String.valueOf(bakery[positionRow - 1][positionCol]));
                    money += current;
                    bakery[positionRow - 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionRow--;

                }else if (bakery[positionRow - 1][positionCol] == '-') {
                    bakery[positionRow - 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionRow--;

                }else if (bakery[positionRow - 1][positionCol] == 'O') {
                    bakery[positionRow - 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    jump(bakery, positionRow -1, positionCol);
                    positionRow = newRow(bakery);
                    positionCol = newCol(bakery);
                }

            }else if (command.equals("down")) {
                if(positionRow == size - 1) {
                    bakery[positionRow][positionCol] = '-';
                    break;

                }else if(Character.isDigit(bakery[positionRow + 1][positionCol])) {
                    int current = Integer.parseInt(String.valueOf(bakery[positionRow + 1][positionCol]));
                    money += current;
                    bakery[positionRow + 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionRow++;

                }else if (bakery[positionRow + 1][positionCol] == '-') {
                    bakery[positionRow + 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionRow++;

                }else if (bakery[positionRow + 1][positionCol] == 'O') {
                    bakery[positionRow + 1][positionCol] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    jump(bakery, positionRow + 1, positionCol);
                    positionRow = newRow(bakery);
                    positionCol = newCol(bakery);
                }

            }else if (command.equals("left")) {
                if(positionCol == 0) {
                    bakery[positionRow][positionCol] = '-';
                    break;

                }else if(Character.isDigit(bakery[positionRow][positionCol -1])) {
                    int current = Integer.parseInt(String.valueOf(bakery[positionRow][positionCol - 1]));
                    money += current;
                    bakery[positionRow][positionCol - 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionCol--;

                }else if (bakery[positionRow][positionCol - 1] == '-') {
                    bakery[positionRow][positionCol - 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionCol--;

                }else if (bakery[positionRow][positionCol - 1] == 'O') {
                    bakery[positionRow][positionCol - 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    jump(bakery, positionRow, positionCol -1);
                    positionRow = newRow(bakery);
                    positionCol = newCol(bakery);
                }

            }else if (command.equals("right")) {
                if(positionCol == size - 1) {
                    bakery[positionRow][positionCol] = '-';
                    break;

                }else if(Character.isDigit(bakery[positionRow][positionCol + 1])) {
                    int current = Integer.parseInt(String.valueOf(bakery[positionRow][positionCol + 1]));
                    money += current;
                    bakery[positionRow][positionCol + 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionCol++;

                }else if (bakery[positionRow][positionCol + 1] == '-') {
                    bakery[positionRow][positionCol + 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    positionCol++;

                }else if (bakery[positionRow][positionCol + 1] == 'O') {
                    bakery[positionRow][positionCol + 1] = 'S';
                    bakery[positionRow][positionCol] = '-';
                    jump(bakery, positionRow, positionCol + 1);
                    positionRow = newRow(bakery);
                    positionCol = newCol(bakery);
                }

            }
        }

        if(money < 50) {
            System.out.println("Bad news, you are out of the bakery.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(bakery[row][col]);
            }
            System.out.println();
        }
    }

    private static void jump(char[][] bakery, int row, int col) {
        for (int rows = 0; rows < bakery.length; rows++) {
            for (int cols = 0; cols < bakery[rows].length; cols++) {
                if(bakery[rows][cols] == 'O') {
                    bakery[rows][cols] = 'S';
                    bakery[row][col] = '-';
                }
            }
        }
    }

    private static int newRow (char[][] bakery){
        int row = 0;
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j] == 'S') {
                    row = i;
                }
            }
        }
        return row;
    }

    private static int newCol (char[][] bakery){
        int col = 0;
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j] == 'S') {
                    col = j;
                }
            }
        }
        return col;
    }
}
