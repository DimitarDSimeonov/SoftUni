import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatedString(inputString, repeatTimes));

    }
    private static String repeatedString (String in, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += in;
        }
        return result;
    }
}
