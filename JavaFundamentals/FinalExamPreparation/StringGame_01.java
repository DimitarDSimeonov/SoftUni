import java.util.Scanner;

public class StringGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Done")){
            if(command.contains("Change")){//"Change {char} {replacement}"
                String oldChar = command.split(" ")[1];
                String newChar = command.split(" ")[2];
                String newText = text.toString().replace(oldChar, newChar);
                text.replace(0, text.length() , newText);
                System.out.println(text);

            }else if (command.contains("Includes")){ //"Includes {substring}"
                String substring = command.split(" ")[1];
                if(text.toString().contains(substring)){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }

            }else if (command.contains("End")){ //End {substring}
                String substring = command.split(" ")[1];
                int length = substring.length();
                String mySubstring = text.substring(text.length() - length);
                if (mySubstring.equals(substring)){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }

            }else if (command.contains("Uppercase")){
                String newText = text.toString().toUpperCase();
                text.replace(0, text.length(), newText);
                System.out.println(text);

            }else if (command.contains("FindIndex")){ //FindIndex {char}
                String symbol = command.split(" ")[1];
                System.out.println(text.indexOf(symbol));

            }else if (command.contains("Cut")){ //Cut {startIndex} {count}
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int count = Integer.parseInt(command.split(" ")[2]);
                String cuteText = text.substring(startIndex, startIndex + count);
                System.out.println(cuteText);

            }
            command = scanner.nextLine();
        }
    }
}
