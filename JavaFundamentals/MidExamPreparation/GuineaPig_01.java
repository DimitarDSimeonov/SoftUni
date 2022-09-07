import java.util.Scanner;

public class GuineaPig_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodKg = Double.parseDouble(scanner.nextLine());
        double heyKg = Double.parseDouble(scanner.nextLine());
        double coverKg = Double.parseDouble(scanner.nextLine());
        double pigWeightKg = Double.parseDouble(scanner.nextLine());
        boolean allIsOk = true;

        for (int day = 1; day <= 30 ; day++) {
            foodKg -= 0.3;
            if (day % 2 == 0){
                heyKg -= foodKg * 0.05;
            }
            if (day % 3 == 0){
                coverKg -= pigWeightKg/3;
            }
            if ( foodKg < 0.3 || heyKg <= 0 || coverKg <= 0){
                System.out.println("Merry must go to the pet store!");
                allIsOk = false;
                break;
            }

        }
        if (allIsOk) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodKg, heyKg, coverKg);
        }
    }
}
