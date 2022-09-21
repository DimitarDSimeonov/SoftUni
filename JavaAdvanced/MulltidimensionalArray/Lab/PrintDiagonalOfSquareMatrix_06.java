package mulltidimensionalArrayLab;

import java.util.Scanner;

public class PrintDiagonalOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        for (int row = 0,col = 0; row < size && col < size; row++, col++) {
            System.out.print(matrix[row][col] + " ");
        }
        System.out.println();
        for (int row = size-1, col = 0; row >= 0 && col < size ; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
    }
}
