package articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Articles> articlesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String title = input.split(", ")[0];
            String contend = input.split(", ")[1];
            String author = input.split(", ")[2];

            Articles article = new Articles(title, contend, author);
            articlesList.add(article);
        }
        String command = scanner.nextLine();

        for (Articles article : articlesList){
            System.out.println(article.toString());
        }
    }
}
