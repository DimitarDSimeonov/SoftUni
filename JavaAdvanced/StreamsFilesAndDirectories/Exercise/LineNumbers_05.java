package streamsFilesAndDirectoriesExercise;

import java.io.*;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("resources/inputLineNumbers.txt"));
        PrintWriter pr = new PrintWriter("resources/output.txt");

        String line = bf.readLine();
        int counter = 0;

        while (line != null){
            counter++;

            pr.println(counter + ". " + line);

            line = bf.readLine();
        }
        bf.close();
        pr.close();
    }
}
