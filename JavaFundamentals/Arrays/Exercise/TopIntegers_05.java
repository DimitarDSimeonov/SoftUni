import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int index = 0; index <= inArr.length - 1; index++) {
            int currentNum = inArr[index];

               if (index == inArr.length -1){
                    System.out.print(currentNum + " ");
                    break;
                }
               boolean isTop = false;

               for (int i = index + 1; i <= inArr.length - 1; i++) {
                   int nextNum = inArr[i];
                    if (currentNum > nextNum){
                        isTop = true;

                    }else{
                        isTop = false;
                        break;
                    }

               }
               if (isTop){
                    System.out.print(currentNum + " ");
               }
            }
        }
    }

