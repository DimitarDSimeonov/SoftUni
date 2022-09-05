import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        printSmallerNum(first, second, third);

    }
    private static void printSmallerNum (int one, int two, int three){
        if (one <= two && one <= three){
            System.out.println(one);

        }else if (two <= one && two <= three){
            System.out.println(two);

        }else if (three <= one && three < two){
            System.out.println(three);
        }
    }
}
