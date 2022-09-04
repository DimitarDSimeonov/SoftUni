import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int initHours = Integer.parseInt(scanner.nextLine());
        int initMinute = Integer.parseInt(scanner.nextLine());

        int allMinute = (initHours * 60) + initMinute + 30;

        int hour = allMinute / 60;
        int minute = allMinute % 60;

        if (hour > 23) {
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, minute);
    }
}