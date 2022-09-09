import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] usernames = scanner.nextLine().split(", ");

        for (String user : usernames){
            if(isValid(user)){
                System.out.println(user);
            }
        }
    }
    public static boolean isValid (String name){
        if(name.length() < 3 || name.length() > 16){
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char symbol = name.charAt(i);
            if(!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_'){
                return false;
            }
        }
        return true;
    }
}
