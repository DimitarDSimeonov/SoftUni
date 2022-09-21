package mulltidimensionalArrayLab;

import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int sum = 0;
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                sum += Integer.parseInt(currentRow[col]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
