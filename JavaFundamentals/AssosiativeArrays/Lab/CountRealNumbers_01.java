import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numMap = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            double key = nums[i];
            if (!numMap.containsKey(key)){
                numMap.put(key, 1);
            }else {
                int currentCount = numMap.get(key);
                numMap.put(key, currentCount + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numMap.entrySet()) {
            System.out.printf("%.0f -> %d%n",entry.getKey(), entry.getValue());
        }

    }
}
