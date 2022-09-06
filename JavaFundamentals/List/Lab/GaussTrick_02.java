import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer :: parseInt).collect(Collectors.toList());

        int sizeList = intList.size();

        for (int i = 0; i < sizeList/2; i++) {
            int firstNum = intList.get(i);
            int secondNum = intList.get(intList.size() - 1);

            intList.set(i, firstNum + secondNum);

            intList.remove(intList.size() - 1);
        }
        for (int ele : intList){
            System.out.print(ele + " ");
        }
    }
}
