package polymorphismExercise.vehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("polymorphismExercise.vehicleExtension.Car", getVehicle(scanner));
        vehicleMap.put("polymorphismExercise.vehicleExtension.Truck", getVehicle(scanner));
        vehicleMap.put("polymorphismExercise.vehicleExtension.Bus", getVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            String commandName = command[0];
            String vehicleType = command[1];
            double argument = Double.parseDouble(command[2]);

            switch (commandName) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).driveWithAc(argument));
                    break;
                case "Refuel":
                    try {
                        vehicleMap.get(vehicleType).refuel(argument);
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
            }

        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split(" ");
        String vehicleType = vehicleData[0];
        double fuelQuantity = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType){
            case "polymorphismExercise.vehicleExtension.Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "polymorphismExercise.vehicleExtension.Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "polymorphismExercise.vehicleExtension.Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }
    }
}
