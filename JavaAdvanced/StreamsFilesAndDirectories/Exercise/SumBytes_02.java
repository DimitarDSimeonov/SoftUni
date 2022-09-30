package streamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/input.txt"));

        String line = bf.readLine();
        long sum = 0;

        while (line != null){

            char[] chars = line.toCharArray();
            for (char current : chars) {
                sum += current;
            }

            line = bf.readLine();
        }
        System.out.println(sum);
        bf.close();
    }
}
