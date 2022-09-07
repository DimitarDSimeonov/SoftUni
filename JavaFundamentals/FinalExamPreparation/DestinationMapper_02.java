import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String locations = scanner.nextLine();
        List<String> destination = new ArrayList<>();
        int travelPoints = 0;

        Pattern pattern = Pattern.compile("([=|/])(?<name>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(locations);

        while (matcher.find()){
            String name = matcher.group("name");
            travelPoints += name.length();
            destination.add(name);
        }
        System.out.println("Destinations: " + String.join(", ", destination) );
        System.out.println("Travel Points: " + travelPoints);
    }
}
