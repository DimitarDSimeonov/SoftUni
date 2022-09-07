import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#|\\|])(?<food>[A-Z a-z]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,4})\\1");
        Matcher matcher = pattern.matcher(text);
        int totalCalories = 0;
        List<String> products = new ArrayList<>();

        while (matcher.find()){

            String food = matcher.group("food");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;

            String item = String.format("Item: %s, Best before: %s, Nutrition: %d", food, date, calories);
            products.add(item);
        }
        System.out.printf("You have food to last you for: %d days!%n",totalCalories/2000);
        for (String product : products){
            System.out.println(product);
        }
    }
}
