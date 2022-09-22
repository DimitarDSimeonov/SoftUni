package multidimensionArrayExercise;

import java.util.Scanner;

public class DiagonalDifference_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[][] matrix = new int[size][size];

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0, col = 0; row < size & col < size; row++, col++) {
            primaryDiagonalSum += matrix[row][col];
        }

        for (int row = size - 1, col = 0; row >= 0 && col < size ; row--, col++) {
            secondaryDiagonalSum += matrix[row][col];
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }
}
