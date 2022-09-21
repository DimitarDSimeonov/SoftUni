package mulltidimensionalArrayLab;

import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        int[][] matrix = new int[rows][cols];
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                          matrix[row +1][col] + matrix[row+1][col +1];
                if(sum > maxSum){
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        for (int row = bestRow; row < bestRow + 2; row++) {
            for (int col = bestCol; col < bestCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
