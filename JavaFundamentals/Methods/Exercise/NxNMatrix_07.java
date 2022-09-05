import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num = Integer.parseInt(scanner.nextLine());

        printMatrix(num);
    }
    private static void printMatrix (int n){
        for (int row = 1; row <= n ; row++) {
            for (int colons = 1; colons <= n ; colons++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
