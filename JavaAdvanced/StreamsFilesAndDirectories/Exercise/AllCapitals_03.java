package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class AllCapitals_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("resources/output.txt"));

        String line = br.readLine();

        while (line != null){

            bw.write(line.toUpperCase());
            bw.newLine();

            line = br.readLine();
        }

        br.close();
        bw.close();

    }
}
