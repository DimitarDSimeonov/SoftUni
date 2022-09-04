import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int highSnow = 0;
        int highTime = 0;
        int highQuality = 0;
        double  highVolume = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());
            double value = Math.pow((snow  / time), quality);

            if (value > highVolume){
                highQuality = quality;
                highSnow = snow;
                highTime = time;
                highVolume = value;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",highSnow ,highTime ,highVolume ,highQuality);
    }
}
