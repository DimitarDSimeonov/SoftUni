import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String[n];
        String[] secondArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split(" ");

            if (i % 2 != 0){
                firstArr[i] = inputArr[1];
                secondArr[i] = inputArr[0];
            }else{
                firstArr[i] = inputArr[0];
                secondArr[i] = inputArr[1];
            }
            System.out.print(firstArr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(secondArr[i] + " ");
        }
    }
}
