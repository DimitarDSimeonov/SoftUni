package exam;

import java.util.Scanner;

public class RallyRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String car = scanner.nextLine();

        int carRow = 0;
        int carCol = 0;

        int firstTunnelRow = 0;
        int firstTunnelCol = 0;

        int secondTunnelRow = 0;
        int secondTunnelCol = 0;
        int tunnelCount = 0;

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine().replace(" ","");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'T' && tunnelCount == 0) {
                    firstTunnelRow = row;
                    firstTunnelCol = col;
                    tunnelCount++;
                }else if (matrix[row][col] == 'T' && tunnelCount == 1){
                    secondTunnelRow = row;
                    secondTunnelCol = col;
                }
            }
        }

        boolean finish = false;
        int kilometres = 0;
        matrix[0][0] = 'C';
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (command.equals("up")) {
                int nextRow = carRow - 1;

                if(matrix[nextRow][carCol] == '.') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;
                    kilometres += 10;
                }else if (matrix[nextRow][carCol] == 'T') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;

                    if (carRow == firstTunnelRow && carCol == firstTunnelCol) {
                        matrix[secondTunnelRow][secondTunnelCol] = 'C';
                        matrix[firstTunnelRow][firstTunnelCol] = '.';
                        carRow = secondTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }else {
                        matrix[firstTunnelRow][firstTunnelCol] = 'C';
                        matrix[secondTunnelRow][secondTunnelCol] = '.';
                        carRow = firstTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }
                }else if (matrix[nextRow][carCol] == 'F') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;
                    kilometres += 10;
                    finish = true;
                    break;
                }

            }else if (command.equals("down")) {
                int nextRow = carRow + 1;

                if(matrix[nextRow][carCol] == '.') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;
                    kilometres += 10;
                }else if (matrix[nextRow][carCol] == 'T') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;

                    if (carRow == firstTunnelRow && carCol == firstTunnelCol) {
                        matrix[secondTunnelRow][secondTunnelCol] = 'C';
                        matrix[firstTunnelRow][firstTunnelCol] = '.';
                        carRow = secondTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }else {
                        matrix[firstTunnelRow][firstTunnelCol] = 'C';
                        matrix[secondTunnelRow][secondTunnelCol] = '.';
                        carRow = firstTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }
                }else if (matrix[nextRow][carCol] == 'F') {
                    matrix[nextRow][carCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carRow = nextRow;
                    kilometres += 10;
                    finish = true;
                    break;
                }

            }else if (command.equals("left")) {
                int nextCol = carCol - 1;

                if(matrix[carRow][nextCol] == '.') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;
                    kilometres += 10;
                }else if (matrix[carRow][nextCol] == 'T') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;

                    if (carRow == firstTunnelRow && carCol == firstTunnelCol) {
                        matrix[secondTunnelRow][secondTunnelCol] = 'C';
                        matrix[firstTunnelRow][firstTunnelCol] = '.';
                        carRow = secondTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }else {
                        matrix[firstTunnelRow][firstTunnelCol] = 'C';
                        matrix[secondTunnelRow][secondTunnelCol] = '.';
                        carRow = firstTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }
                }else if (matrix[carRow][nextCol] == 'F') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;
                    kilometres += 10;
                    finish = true;
                    break;
                }

            }else if (command.equals("right")) {
                int nextCol = carCol + 1;

                if(matrix[carRow][nextCol] == '.') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;
                    kilometres += 10;
                }else if (matrix[carRow][nextCol] == 'T') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;

                    if (carRow == firstTunnelRow && carCol == firstTunnelCol) {
                        matrix[secondTunnelRow][secondTunnelCol] = 'C';
                        matrix[firstTunnelRow][firstTunnelCol] = '.';
                        carRow = secondTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }else {
                        matrix[firstTunnelRow][firstTunnelCol] = 'C';
                        matrix[secondTunnelRow][secondTunnelCol] = '.';
                        carRow = firstTunnelRow;
                        carCol = secondTunnelCol;
                        kilometres += 30;
                    }
                }else if (matrix[carRow][nextCol] == 'F') {
                    matrix[carRow][nextCol] = 'C';
                    matrix[carRow][carCol] = '.';
                    carCol = nextCol;
                    kilometres += 10;
                    finish = true;
                    break;
                }

            }

            command = scanner.nextLine();
        }

        if (finish){
            System.out.printf("Racing car %s finished the stage!%n", car);
        }else {
            System.out.printf("Racing car %s DNF.%n",car);
        }
        System.out.printf("Distance covered %d km.%n",kilometres);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
