package multidimensionArrayExercise;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MatrixShuffling_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        String command = scanner.nextLine();

        while (!command.equals("END")){

            String[] commandChecking = command.split(" ");

            if(command.contains("swap") && commandChecking.length == 5) {
                int firstRowIndex = Integer.parseInt(command.split(" ")[1]);
                int firstColIndex = Integer.parseInt(command.split(" ")[2]);

                int secondRowIndex = Integer.parseInt(command.split(" ")[3]);
                int secondColIndex = Integer.parseInt(command.split(" ")[4]);

                if (isValidIndex(rows, cols, firstRowIndex, firstColIndex, secondRowIndex, secondColIndex)) {
                    String firstElement = matrix[firstRowIndex][firstColIndex];
                    String secondElement = matrix[secondRowIndex][secondColIndex];
                    matrix[firstRowIndex][firstColIndex] = secondElement;
                    matrix[secondRowIndex][secondColIndex] = firstElement;

                    printMatrix(rows, cols, matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int rows, int cols, int firstRowIndex, int firstColIndex, int secondRowIndex, int secondColIndex) {
        return firstRowIndex >= 0 && firstRowIndex < rows && firstColIndex >= 0 && firstColIndex < cols
                && secondRowIndex >= 0 && secondRowIndex < rows && secondColIndex >= 0 && secondColIndex < cols;
    }
}
