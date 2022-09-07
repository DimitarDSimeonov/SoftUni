import java.util.*;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder massage = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Decode")){
            if(command.contains("Move")){
                int n = Integer.parseInt(command.split("\\|")[1]);
                if(n > 0 && n <= massage.length()) {
                    for (int i = 0; i < n; i++) {
                        char current = massage.charAt(i);
                        massage.append(current);
                    }
                    massage.delete(0, n);
                }

            }else if(command.contains("Insert")){
                int index = Integer.parseInt(command.split("\\|")[1]);
                String element = command.split("\\|")[2];
                if(index >= 0 ) {
                    massage.insert(index, element);
                }

            }else if(command.contains("ChangeAll")){
                String oldSubstring = command.split("\\|")[1];
                String newSubstring = command.split("\\|")[2];
                String newMassage = massage.toString().replace(oldSubstring, newSubstring);
                massage = new StringBuilder(newMassage);

            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + massage);
    }
}
