import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacityPerWagon = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")){
            int passenger = 0;
            if (command.contains("Add")){
                passenger = Integer.parseInt(command.split(" ")[1]);
                wagons.add(passenger);
            }else{
                passenger = Integer.parseInt(command.split(" ")[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    int currentPassenger = wagons.get(i);
                    if (currentPassenger + passenger <= maxCapacityPerWagon){
                        wagons.set(i, currentPassenger + passenger);
                        break;
                    }
                }
            }




            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
