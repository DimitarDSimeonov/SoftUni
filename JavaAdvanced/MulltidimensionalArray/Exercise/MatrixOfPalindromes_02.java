package multidimensionArrayExercise;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char outside = (char) ('a'+ row);
                char middle = (char) ('a' + row + col);
                System.out.print(matrix[row][col] = "" + outside + middle + outside + " ");
            }
            System.out.println();
        }
    }
}
