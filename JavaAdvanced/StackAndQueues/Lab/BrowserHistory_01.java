package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> url = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (url.size() > 1) {
                    url.pop();
                    System.out.println(url.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else {
                url.push(input);
                System.out.println(url.peek());

            }


            input = scanner.nextLine();
        }
    }
}
