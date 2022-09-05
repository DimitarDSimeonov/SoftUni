import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!passwordLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!passwordConsist(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!numDigitsInPassword(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (passwordLength(password) && passwordConsist(password) && numDigitsInPassword(password)) {
            System.out.println("Password is valid");
        }

      }
      private static boolean passwordLength(String password) {
        boolean isValid = true;
        if (password.length() >= 6 && password.length() <= 10) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
      }

      private static boolean passwordConsist(String password) {
          for (char symbol : password.toCharArray()) {
              if (!Character.isLetterOrDigit(symbol)) {
                  return false;
              }
          }
          return true;
      }
      private static boolean numDigitsInPassword (String password){
            boolean isValid = true;
            int count = 0;
            for (char symbol : password.toCharArray()) {
                if (Character.isDigit(symbol)) {
                    count++;
                }
            }
            if (count >= 2) {
                isValid = true;
            } else {
                isValid = false;
            }
            return isValid;
      }
    }

