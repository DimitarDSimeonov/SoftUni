import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int won = 0;
        boolean weWin = true;

        while (!command.equals("End of battle")){
            int distance = Integer.parseInt(command);
            if (energy - distance >= 0){
                energy -= distance;
                won++;
                if (won % 3 == 0){
                    energy += won;
                }
            }else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",won ,energy);
                weWin = false;
                break;
            }


            command = scanner.nextLine();
        }
        if (weWin){
            System.out.printf("Won battles: %d. Energy left: %d" , won, energy);
        }
    }
}
