package mulltidimensionalArrayLab;

import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstRows = scanner.nextInt();
        int firstCols = scanner.nextInt();
        int[][] firstMatrix = new int[firstRows][firstCols];
        for (int row = 0; row < firstRows; row++) {
            for (int col = 0; col < firstCols; col++) {
                firstMatrix[row][col] = scanner.nextInt();
            }
        }
        int secondRows = scanner.nextInt();
        int secondCols = scanner.nextInt();
        int[][] secondMatrix = new int[secondRows][secondCols];
        for (int row = 0; row < secondRows; row++) {
            for (int col = 0; col < secondCols; col++) {
                secondMatrix[row][col] = scanner.nextInt();
            }
        }
        boolean isEquals = true;
        if(firstRows == secondRows && firstCols == secondCols){
            for (int row = 0; row < firstRows; row++) {
                for (int col = 0; col < firstCols; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]){
                        isEquals = false;
                        break;
                    }
                }
            }
        }else {
            isEquals = false;
        }
        if(isEquals){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
}
