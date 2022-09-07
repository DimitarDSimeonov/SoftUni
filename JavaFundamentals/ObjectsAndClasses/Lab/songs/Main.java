package songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSong = Integer.parseInt(scanner.nextLine());
        List<Songs> listWhitSong = new ArrayList<>();

        for (int i = 0; i < numberOfSong; i++) {
            String input = scanner.nextLine();
            String type = input.split("_")[0];
            String name = input.split("_")[1];
            String time = input.split("_")[2];

            Songs song = new Songs(type, name, time);
            listWhitSong.add(song);
        }
        String command = scanner.nextLine();

        for (Songs song : listWhitSong){
            if (command.equals("all")){
                System.out.println(song.getName());
            }else if (command.equals(song.getType())){
                System.out.println(song.getName());
            }
        }
    }
}
