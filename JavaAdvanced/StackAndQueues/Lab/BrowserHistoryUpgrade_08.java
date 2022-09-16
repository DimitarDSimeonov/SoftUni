package stackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String current = null;

        ArrayDeque<String> url = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (url.size() > 1) {
                    current = url.pop();
                    forward.push(current);
                    System.out.println(url.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            }else if(input.equals("forward")){
                if(!forward.isEmpty()){
                    current = forward.pop();
                    url.push(current);
                    System.out.println(current);

                }else{
                    System.out.println("no next URLs");
                }

            } else {
                url.push(input);
                System.out.println(url.peek());

            }


            input = scanner.nextLine();
        }
    }
}
