import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] packing = scanner.nextLine().split("\\\\");
        String fileLocation = packing[packing.length -1];
        String file = fileLocation.split("\\.")[0];
        String extension = fileLocation.split("\\.")[1];

        System.out.printf("File name: %s%n",file);
        System.out.printf("File extension: %s%n",extension);
    }
}
