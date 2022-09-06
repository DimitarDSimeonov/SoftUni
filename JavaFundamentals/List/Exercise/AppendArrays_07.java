import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> inList = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(inList);
        System.out.println(inList.toString().replace("[", "")
                                            .replace("]", "")
                                            .trim()
                                            .replaceAll(",", "")
                                            .replaceAll("\\s+", " "));
    }
}
