package streamsFilesAndDirectoriesExercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class GetFolderSize_08 {
    public static void main(String[] args) throws IOException {
        File folder = new File("resources/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();

        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()){

            File current = directories.poll();
            File[] files = current.listFiles();

            for (File file : files) {
                if(file.isDirectory()){
                    directories.offer(file);
                }else {
                    sumOfBytes += file.length();
                }
            }

        }
        PrintWriter pw = new PrintWriter("resources/output.txt");

        pw.println("Folder size: " + sumOfBytes);
        pw.close();

    }
}
