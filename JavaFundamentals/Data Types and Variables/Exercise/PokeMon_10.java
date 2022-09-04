import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startPower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int factor = Integer.parseInt(scanner.nextLine());
        int poke = 0;
        int power = startPower;

        while (power >= distance){
            power -= distance;
            poke++;
            if (power == 0.5 * startPower){
                if (factor > 0){
                power /= factor;
                }
            }
        }
        System.out.println(power);
        System.out.println(poke);
    }
}
