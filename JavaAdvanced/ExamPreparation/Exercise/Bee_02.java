package examPreparationExercise;

import java.util.Scanner;

public class Bee_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[matrixSize][matrixSize];

        int beeRow = 0;
        int beeCol = 0;
        int flowerCount = 0;

        for (int row = 0; row < matrixSize; row++) {
            String inputRow = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = inputRow.charAt(col);
                if (inputRow.charAt(col) == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        boolean beeIsLost = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (command.equals("up")) {
                if(beeRow == 0){
                    matrix[beeRow][beeCol] = '.';
                    beeIsLost = true;
                    break;

                }else if (matrix[beeRow - 1][beeCol] == '.') {
                    matrix[beeRow - 1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow--;

                }else if (matrix[beeRow - 1][beeCol] == 'f') {
                    flowerCount++;
                    matrix[beeRow -1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow--;

                }else if (matrix[beeRow - 1][beeCol] == 'O') {
                    matrix[beeRow - 1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow--;

                    if(beeRow == 0){
                        matrix[beeRow][beeCol] = '.';
                        beeIsLost = true;
                        break;

                    }else if (matrix[beeRow - 1][beeCol] == '.') {
                        matrix[beeRow - 1][beeCol] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeRow--;

                    }else if (matrix[beeRow - 1][beeCol] == 'f') {
                        flowerCount++;
                        matrix[beeRow -1][beeCol] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeRow--;

                    }


                }

            }else if (command.equals("down")) {
                if(beeRow == matrixSize -1){
                    matrix[beeRow][beeCol] = '.';
                    beeIsLost = true;
                    break;

                }else if (matrix[beeRow + 1][beeCol] == '.') {
                    matrix[beeRow + 1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow++;

                }else if (matrix[beeRow + 1][beeCol] == 'f') {
                    flowerCount++;
                    matrix[beeRow + 1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow++;

                }else if (matrix[beeRow + 1][beeCol] == 'O') {
                    matrix[beeRow + 1][beeCol] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeRow++;

                    if(beeRow == matrixSize -1){
                        matrix[beeRow][beeCol] = '.';
                        beeIsLost = true;
                        break;

                    }else if (matrix[beeRow + 1][beeCol] == '.') {
                        matrix[beeRow + 1][beeCol] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeRow++;

                    }else if (matrix[beeRow + 1][beeCol] == 'f') {
                        flowerCount++;
                        matrix[beeRow + 1][beeCol] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeRow++;

                    }
                }

            }else if (command.equals("left")) {
                if (beeCol == 0) {
                    matrix[beeRow][beeCol] = '.';
                    beeIsLost = true;
                    break;

                }else if (matrix[beeRow][beeCol - 1] == '.') {
                    matrix[beeRow][beeCol - 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol--;

                }else if (matrix[beeRow][beeCol - 1] == 'f') {
                    flowerCount++;
                    matrix[beeRow][beeCol - 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol--;

                }else if (matrix[beeRow][beeCol - 1] == 'O') {
                    matrix[beeRow][beeCol - 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol--;

                    if (beeCol == 0) {
                        matrix[beeRow][beeCol] = '.';
                        beeIsLost = true;
                        break;

                    }else if (matrix[beeRow][beeCol - 1] == '.') {
                        matrix[beeRow][beeCol - 1] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeCol--;

                    }else if (matrix[beeRow][beeCol - 1] == 'f') {
                        flowerCount++;
                        matrix[beeRow][beeCol - 1] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeCol--;

                    }
                }

            }else if (command.equals("right")) {
                if (beeCol == matrixSize -1) {
                    matrix[beeRow][beeCol] = '.';
                    beeIsLost = true;
                    break;

                }else if (matrix[beeRow][beeCol + 1] == '.') {
                    matrix[beeRow][beeCol + 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol++;

                }else if (matrix[beeRow][beeCol + 1] == 'f') {
                    flowerCount++;
                    matrix[beeRow][beeCol + 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol++;

                }else if (matrix[beeRow][beeCol + 1] == 'O') {
                    matrix[beeRow][beeCol + 1] = 'B';
                    matrix[beeRow][beeCol] = '.';
                    beeCol++;

                    if (beeCol == matrixSize - 1) {
                        matrix[beeRow][beeCol] = '.';
                        beeIsLost = true;
                        break;

                    }else if (matrix[beeRow][beeCol + 1] == '.') {
                        matrix[beeRow][beeCol + 1] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeCol++;

                    }else if (matrix[beeRow][beeCol + 1] == 'f') {
                        flowerCount++;
                        matrix[beeRow][beeCol + 1] = 'B';
                        matrix[beeRow][beeCol] = '.';
                        beeCol++;

                    }
                }

            }

            command = scanner.nextLine();
        }
        if (beeIsLost){
            System.out.println("The bee got lost!");
        }
        if(flowerCount >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n" , flowerCount);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n" , 5 - flowerCount);
        }

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
