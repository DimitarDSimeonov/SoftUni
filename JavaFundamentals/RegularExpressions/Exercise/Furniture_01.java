import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> furniture = new ArrayList<>();
        double sum = 0;

        while (!input.equals("Purchase")){
            Pattern pattern = Pattern.compile(">>(?<item>[a-zA-Z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String item = matcher.group("item");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furniture.add(item);
                sum += price * quantity;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String item : furniture){
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f%n",sum);
    }
}
