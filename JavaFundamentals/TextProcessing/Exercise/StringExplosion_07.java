import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder(input);
        int totalPower = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if(currentChar == '>'){
                int power = Integer.parseInt(text.charAt(i + 1) + "");
                totalPower += power;
            }else  if (currentChar != '>' && totalPower > 0){
                text.deleteCharAt(i);
                totalPower--;
                i--;
            }
        }
        System.out.println(text);
    }
}
