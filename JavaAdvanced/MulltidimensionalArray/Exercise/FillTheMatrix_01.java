package multidimensionArrayExercise;

import java.util.Scanner;

public class FillTheMatrix_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[size][size];
        int counter = 1;

        if(method.equals("A")){

            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }

        }else if(method.equals("B")) {

            for (int col = 0; col < size; col++) {

                if(col % 2 == 0){
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                }else{
                    for (int row = size - 1; row >= 0 ; row--) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
