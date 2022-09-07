import java.util.Arrays;
import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoin = 0;
        int bestRoom = 0;
        boolean isLive = true;

        for (int i = 0; i < rooms.length; i++) {
            String[] command = rooms[i].split(" ");
            String monster = command[0];
            int power = Integer.parseInt(command[1]);
            bestRoom++;

            switch (monster){
                case "potion":
                    if (power + health <= 100){
                        System.out.printf("You healed for %d hp.%n",power);
                        health += power;
                        System.out.printf("Current health: %d hp.%n",health);
                    }else {
                        System.out.printf("You healed for %d hp.%n",100 - health);
                        health = 100;
                        System.out.printf("Current health: %d hp.%n",health);
                    }
                    break;
                case "chest":
                    System.out.printf("You found %d bitcoins.%n",power);
                    bitcoin += power;
                    break;
                default:
                    health -= power;
                    if (health > 0){
                        System.out.printf("You slayed %s.%n",monster);
                    }else{
                        System.out.printf("You died! Killed by %s.%n",monster);
                        System.out.printf("Best room: %d%n",bestRoom);
                        isLive = false;
                    }

                    break;
            }
            if(!isLive){
                break;
            }

        }
        if (isLive){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n",bitcoin);
            System.out.printf("Health: %d%n",health);
        }
    }
}
