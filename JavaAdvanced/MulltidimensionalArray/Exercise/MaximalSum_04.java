package multidimensionArrayExercise;

import java.util.Scanner;

public class MaximalSum_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        
        int maxSum = Integer.MIN_VALUE;
        int bestRowIndex = 0;
        int bestColIndex = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < rows -2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum){
                    maxSum = sum;
                    bestRowIndex = row;
                    bestColIndex = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = bestRowIndex; row < bestRowIndex + 3 ; row++) {
            for (int col = bestColIndex; col < bestColIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
