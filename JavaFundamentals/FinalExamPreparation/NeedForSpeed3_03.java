import java.util.*;

public class NeedForSpeed3_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> allCars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            //"{car}|{mileage}|{fuel}"
            String input = scanner.nextLine();
            String car = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);

            List<Integer> carInfo = new ArrayList<>();
            carInfo.add(mileage);
            carInfo.add(fuel);
            allCars.put(car,carInfo);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            if(command.contains("Drive")){
                //•	"Drive : {car} : {distance} : {fuel}"
                String car = command.split(" : ")[1];
                int distance = Integer.parseInt(command.split(" : ")[2]);
                int fuel = Integer.parseInt(command.split(" : ")[3]);

                int currentMileage = allCars.get(car).get(0);
                int currentFuel = allCars.get(car).get(1);

                if(fuel > currentFuel){
                    System.out.println("Not enough fuel to make that ride");

                }else {
                    allCars.get(car).set(0, currentMileage + distance);
                    allCars.get(car).set(1, currentFuel - fuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car, distance, fuel);
                }
                if(allCars.get(car).get(0) >= 100000){
                    System.out.printf("Time to sell the %s!%n",car);
                    allCars.remove(car);
                }

            }else if (command.contains("Refuel")){
                String car = command.split(" : ")[1];
                int fuel = Integer.parseInt(command.split(" : ")[2]);
                int currentFuel = allCars.get(car).get(1);
                if(currentFuel + fuel > 75){
                    allCars.get(car).set(1, 75);
                    System.out.printf("%s refueled with %d liters%n",car, 75-currentFuel);
                }else{
                    allCars.get(car).set(1, currentFuel + fuel);
                    System.out.printf("%s refueled with %d liters%n",car, fuel);
                }

            }else if (command.contains("Revert")){
                String car = command.split(" : ")[1];
                int mileage = Integer.parseInt(command.split(" : ")[2]);
                int currentMileage = allCars.get(car).get(0);

                if (allCars.get(car).get(0) - mileage >= 10000){
                    allCars.get(car).set(0, currentMileage - mileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n",car, mileage);

                }else {
                    allCars.get(car).set(0, 10000);
                }
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : allCars.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                    ,entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
