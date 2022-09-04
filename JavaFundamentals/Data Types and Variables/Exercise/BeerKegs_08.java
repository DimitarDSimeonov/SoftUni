import java.util.Scanner;

public class BeerKegs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double biggestVolume = Double.MIN_VALUE;
        String model = "";

        for (int i = 0; i < n; i++) {
            String kegName = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double kegVolume = Math.PI * Math.pow(radius, 2) * height;
            if (kegVolume > biggestVolume){
                biggestVolume = kegVolume;
                model = kegName;
            }
        }
        System.out.println(model);
    }
}
