import java.util.Locale;
import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String worldStops = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder stops = new StringBuilder(worldStops);

        while (!command.equals("Travel")){
            //Add Stop:{index}:{string}
            if (command.contains("Add Stop")){
                int index = Integer.parseInt(command.split(":")[1]);
                String newStop = command.split(":")[2];

                if(isValidIndex(index, stops)){
                    stops.insert(index, newStop);
                }
                System.out.println(stops);

            //Remove Stop:{start_index}:{end_index}
            }else if(command.contains("Remove Stop")){
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);

                if(isValidIndex(startIndex, stops) && isValidIndex(endIndex, stops)){
                    stops.delete(startIndex, endIndex + 1);
                }
                System.out.println(stops);

            //Switch:{old_string}:{new_string}
            }else if(command.contains("Switch")){
                String oldString = command.split(":")[1];
                String newString = command.split(":")[2];
                String replaced = stops.toString().replace(oldString, newString);
                stops = new StringBuilder(replaced);

                System.out.println(stops);
            }
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
    public static boolean isValidIndex (int i , StringBuilder sb){
        return i >= 0 && i < sb.length();
    }
}
