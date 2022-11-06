package workingWithAbstractionExercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] size = readArray(scanner);
            int row = size[0];
            int col = size[1];

            int[][] galaxy = new int[row][col];

            int value = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    galaxy[i][j] = value++;
                }
            }

            String command = scanner.nextLine();
            long sum = 0;

            while (!command.equals("Let the Force be with you")) {

                int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evil = readArray(scanner);
                int evilRow = evil[0];
                int evilCol = evil[1];

                evilRun(galaxy, evilRow, evilCol);

                int jediRow = ivoS[0];
                int jediCol = ivoS[1];

                sum = getSumForJediRun(galaxy, sum, jediRow, jediCol);

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static long getSumForJediRun(int[][] galaxy, long sum, int jediRow, int jediCol) {
        while (jediRow >= 0 && jediCol < galaxy[1].length) {

            if (jediRow < galaxy.length && jediCol >= 0 && jediCol < galaxy[0].length)
            {
                sum += galaxy[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static void evilRun(int[][] galaxy, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {

            if (evilRow < galaxy.length && evilCol < galaxy[0].length)
            {
                galaxy[evilRow] [evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
