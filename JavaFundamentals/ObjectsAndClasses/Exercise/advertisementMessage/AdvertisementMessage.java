package advertisementMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrases = new ArrayList<>();
        List<String> events = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        List<String> cities = new ArrayList<>();

        phrases.add("Excellent product.");
        phrases.add("Such a great product.");
        phrases.add("I always use that product.");
        phrases.add("Best product of its category.");
        phrases.add("Exceptional product.");
        phrases.add("I can’t live without this product.");

        events.add("Now I feel good.");
        events.add("I have succeeded with this product.");
        events.add("Makes miracles. I am happy of the results!");
        events.add("I cannot believe but now I feel awesome.");
        events.add("Try it yourself, I am very satisfied.");
        events.add("I feel great!");

        //– {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
        authors.add("Diana");
        authors.add("Petya");
        authors.add("Stella");
        authors.add("Elena");
        authors.add("Katya");
        authors.add("Annie");
        authors.add("Eva");

        //{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
        cities.add("Burgas");
        cities.add("Sofia");
        cities.add("Plovdiv");
        cities.add("Varna");
        cities.add("Ruse");

        int n = Integer.parseInt(scanner.nextLine()); //номер на събщенията

        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            int phrasesIndex = rnd.nextInt(phrases.size());
            int eventIndex = rnd.nextInt(events.size());
            int authorIndex = rnd.nextInt(authors.size());
            int cityindex = rnd.nextInt(cities.size());

            System.out.printf("%s %s %s – %s%n", phrases.get(phrasesIndex), events.get(eventIndex), authors.get(authorIndex), cities.get(cityindex));
        }
    }
}
