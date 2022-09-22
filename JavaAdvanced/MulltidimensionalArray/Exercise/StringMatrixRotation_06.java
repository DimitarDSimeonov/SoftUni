package multidimensionArrayExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotation = scanner.nextLine().split("\\(");
        int degrees = Integer.parseInt(rotation[1].replaceAll("\\)", "")) % 360;

        String input = scanner.nextLine();

        int rows = 0;
        int cols = 0;

        ArrayDeque<String> queueRows = new ArrayDeque<>();

        while (!input.equals("END")){

            rows++;

            if (input.length() > cols){
                cols = input.length();
            }

            queueRows.offer(input);

            input = scanner.nextLine();
        }

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = ' ';
            }
        }

        for (int row = 0; row < rows; row++) {
            String currentRow = queueRows.poll();
            for (int col = 0; col < currentRow.length(); col++) {
                matrix[row][col] = currentRow.charAt(col);
            }
        }

        switch (degrees){
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + "");
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols ; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col] + "");
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0 ; row--) {
                    for (int col = cols - 1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col] + "");
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0 ; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col] + "");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
