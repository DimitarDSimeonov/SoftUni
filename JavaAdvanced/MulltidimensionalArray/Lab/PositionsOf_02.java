package mulltidimensionalArrayLab;

import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               matrix[row][col] = scanner.nextInt();
            }
        }
        int searchingNum = scanner.nextInt();
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] == searchingNum){
                    System.out.println(row + " " + col);
                    counter++;
                }
            }
        }
        if (counter == 0){
            System.out.println("not found");
        }
    }
}
