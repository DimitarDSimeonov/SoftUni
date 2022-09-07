import java.util.*;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder massage = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Reveal")){
            if(command.contains("InsertSpace")){
                int index = Integer.parseInt(command.split(":\\|:")[1]);
                massage.insert(index, " ");
                System.out.println(massage);

            }else if(command.contains("Reverse")){
                String substring = command.split(":\\|:")[1];
                if(massage.toString().contains(substring)){
                    String editMassage = massage.toString();
                    StringBuilder reversedElement = new StringBuilder(substring).reverse();
                    editMassage = editMassage.replaceFirst(substring, "");
                    massage.replace(0, massage.length(), editMassage);
                    massage.append(reversedElement);
                    System.out.println(massage);
                }else{
                    System.out.println("error");
                }

            }else if(command.contains("ChangeAll")){
                String substring = command.split(":\\|:")[1];
                String newSubstring= command.split(":\\|:")[2];
                String newMassage = massage.toString().replaceAll(substring, newSubstring);
                massage = new StringBuilder(newMassage);
                System.out.println(massage);
            }

            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + massage);
    }
}
