import java.text.BreakIterator;
import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        String correctPassword = sb.append(username).reverse().toString();
        int error = 0;

        for (int i = 0; i < 3; i++) {
            if (password.equals(correctPassword)){
                System.out.printf("User %s logged in.%n",username);
                break;
            }else{
                System.out.printf("Incorrect password. Try again.%n");
                password = scanner.nextLine();
                error++;
            }

        }
        if (error >= 3){
            System.out.printf("User %s blocked!",username);
        }
    }
}
