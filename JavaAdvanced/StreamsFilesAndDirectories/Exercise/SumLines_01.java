package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bf.readLine();

        while (line != null){

            long sum = 0;
            char[] chars = line.toCharArray();
            for (char current : chars) {
                sum += current;
            }

            System.out.println(sum);
            line = bf.readLine();
        }
        bf.close();

    }
}
