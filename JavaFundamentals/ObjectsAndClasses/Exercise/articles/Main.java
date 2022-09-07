package articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArticle = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());//брой редакции

        String title = inputArticle[0];
        String contend = inputArticle[1];
        String author = inputArticle[2];

        Articles article = new Articles(title, contend, author);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\: ");
            String command = input[0];
            switch (command){
                case "Edit":
                    String newContend = input[1];
                    article.Edit(newContend);
                    break;
                case "ChangeAuthor":
                    String newAuthor = input[1];
                    article.ChangeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = input[1];
                    article.Rename(newTitle);
                    break;
            }

        }
        System.out.println(article.toString());

    }
}
