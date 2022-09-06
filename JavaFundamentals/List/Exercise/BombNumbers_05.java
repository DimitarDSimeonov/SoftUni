import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> commands = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int bomb = commands.get(0);
        int power = commands.get(1);

        for (int i = 0; i < numbers.size(); i++) {
            if (bomb == numbers.get(i)){
                for (int j = 0; j < power; j++) {
                    if (i < numbers.size() - 1) {
                        numbers.remove(i + 1);
                    }
                }
                for (int j = 0; j < power; j++) {
                    if (i > 0) {
                        numbers.remove(i - 1);
                        i -= 1;
                    }
                }
                numbers.remove(i);
                i -= 1;
            }
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(sum);

    }
}
