import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String element : secondArr){
            for ( String elementOne : firstArr){
                if (element.equals(elementOne)){
                    System.out.print(element + " ");
                }
              }

            }
        }
    }

