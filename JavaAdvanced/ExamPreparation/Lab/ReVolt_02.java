package examPraparationLab;

import java.util.Scanner;

public class ReVolt_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int stepCounts = Integer.parseInt(scanner.nextLine());

        int playerRow = 0;
        int playerCol = 0;

        char[][] matrix = new char[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = input.charAt(col);
                if(matrix[row][col] == 'f'){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        boolean playerWin = false;

        for (int i = 0; i < stepCounts; i++) {
            String command = scanner.nextLine();
            if(command.equals("up")){
                int nextRow = playerRow - 1;
                if(playerRow == 0) {
                    nextRow = matrixSize - 1;
                }
                if (matrix[nextRow][playerCol] == '-') {
                    matrix[nextRow][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerRow = nextRow;

                } else if (matrix[nextRow][playerCol] == 'B') {
                    if(nextRow == 0) {
                        nextRow = matrixSize - 1;
                    }
                    if (matrix[nextRow][playerCol] == '-') {
                        matrix[nextRow][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerRow = nextRow;

                    } else if (matrix[nextRow][playerCol] == 'F') {
                        matrix[nextRow][playerCol] = 'f';
                        matrix[0][playerCol] = '-';
                        playerRow = nextRow;
                        playerWin = true;
                        break;
                    }

                } else if (matrix[nextRow][playerCol] == 'F') {
                    matrix[nextRow][playerCol] = 'f';
                    matrix[0][playerCol] = '-';
                    playerRow = nextRow;
                    playerWin = true;
                    break;
                }
            }else if (command.equals("down")){
                int nextRow = playerRow + 1;
                if (playerRow  == matrixSize - 1) {
                    nextRow = 0;
                }
                if (matrix[nextRow][playerCol] == '-') {
                    matrix[nextRow][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerRow = nextRow;
                }else if (matrix[nextRow][playerCol] == 'B') {
                    if (nextRow == matrixSize -1) {
                        nextRow = 0;
                    }
                    if (matrix[nextRow + 1][playerCol] == '-') {
                        matrix[nextRow + 1][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerRow = nextRow +1;
                    }else if (matrix[nextRow + 1][playerCol] == 'F') {
                        matrix[nextRow + 1][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerRow = nextRow;
                        playerWin = true;
                        break;
                    }
                }else if (matrix[nextRow][playerCol] == 'F') {
                    matrix[nextRow][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerRow = nextRow;
                    playerWin = true;
                    break;
                }

            }else if (command.equals("left")) {
                int nextCol = playerCol - 1;
                if(nextCol < 0) {
                    nextCol = matrixSize - 1;
                }
                if(matrix[playerRow][nextCol] == '-') {
                    matrix[playerRow][nextCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextCol;

                }else if (matrix[playerRow][nextCol] == 'B') {
                    if (nextCol - 1 < 0) {
                        nextCol = matrixSize - 1;
                    }
                    if (matrix[playerRow][nextCol] == '-') {
                        matrix[playerRow][nextCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerCol = nextCol;

                    }else if (matrix[playerRow][nextCol] == 'F') {
                        matrix[playerRow][nextCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerCol = nextCol;
                        playerWin = true;
                        break;
                    }

                }else if(matrix[playerRow][nextCol] == 'F') {
                    matrix[playerRow][nextCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextCol;
                    playerWin = true;
                    break;
                }

            }else if(command.equals("right")){
                int nextCol = playerCol + 1;
                if (nextCol == matrixSize) {
                    nextCol = 0;
                }
                if(matrix[playerRow][nextCol] == '-') {
                    matrix[playerRow][nextCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextCol;

                }else if (matrix[playerRow][nextCol] == 'B') {
                    if(nextCol + 1 == matrixSize) {
                        nextCol = 0;
                    }

                    if ( matrix[playerRow][nextCol] == '-') {
                        matrix[playerRow][nextCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerCol = nextCol;
                    }else if (matrix[playerRow][nextCol] == 'F') {
                        matrix[playerRow][nextCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerCol = nextCol;
                        playerWin = true;
                        break;
                    }

                }else if (matrix[playerRow][nextCol] == 'F') {
                    matrix[playerRow][nextCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextCol;
                    playerWin = true;
                    break;
                }

            }
        }
        if (playerWin) {
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
