import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double totalSum = 0;

        for (String str : input){
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(str.length() - 1);
            double num = Double.parseDouble(str.replace(firstChar, ' ').replace(secondChar, ' ').trim());
            double sum = 0;

            if (Character.isUpperCase(firstChar)){
                sum = num /( (int)firstChar - 64);
            }else {
                sum = num * ((int)firstChar - 96);
            }

            if(Character.isUpperCase(secondChar)){
                sum = sum - ((int)secondChar - 64);
            }else {
                sum = sum + ( (int)secondChar - 96);
            }

            totalSum += sum;
        }

        System.out.printf("%.2f", totalSum);
    }
}
