import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");
            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String command = matcher.group("command");
                String message = matcher.group("message");
                List<Integer> translateMessage = new ArrayList<>();

                for (int j = 0; j < message.length(); j++) {
                    int num = (int) message.charAt(j);
                    translateMessage.add(num);
                }
                System.out.print(command + ": ");
                for(Integer num : translateMessage){
                    System.out.print(num + " ");
                }
                System.out.println();

            }else {
                System.out.println("The message is invalid");
            }
        }
    }
}
