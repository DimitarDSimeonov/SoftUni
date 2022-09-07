package vehliceCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String input = scanner.nextLine();

        List<VehicleCatalogue> catalog = new ArrayList<>();

         while (!input.equals("End")){
             String type = input.split(" ")[0];
             String model = input.split(" ")[1];
             String color = input.split(" ")[2];
             int horsePower = Integer.parseInt(input.split(" ")[3]);

             VehicleCatalogue currentCarOrTruck = new VehicleCatalogue(type, model, color, horsePower);

             catalog.add(currentCarOrTruck);

             input = scanner.nextLine();
         }
         String vehicle = scanner.nextLine();
         double sumOfCarPower = 0.0;
         double sumOfTruckPower = 0.0;
         int carCounter = 0;
         int truckCounter = 0;


         while (!vehicle.equals("Close the Catalogue")){
             for (VehicleCatalogue currentVehicle : catalog) {
                 if (currentVehicle.getModel().equals(vehicle)) {
                     System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n",
                             currentVehicle.getType().substring(0,1).toUpperCase() + currentVehicle.getType().substring(1).toLowerCase(), currentVehicle.getModel(), currentVehicle.getColor(), currentVehicle.getHorsePower());
                 }

             }

             vehicle = scanner.nextLine();
         }
         for (VehicleCatalogue carOrTruck : catalog){
             if (carOrTruck.getType().equals("car")){
                 sumOfCarPower += carOrTruck.getHorsePower();
                 carCounter++;

             }else if(carOrTruck.getType().equals("truck")){
                 sumOfTruckPower += carOrTruck.getHorsePower();
                 truckCounter++;

             }
         }
         if (carCounter > 0) {
             System.out.printf("Cars have average horsepower of: %.2f.%n", sumOfCarPower / carCounter);
         }else{
             System.out.println("Cars have average horsepower of: 0.00.");
         }
         if(truckCounter > 0) {
             System.out.printf("Trucks have average horsepower of: %.2f.%n", sumOfTruckPower / truckCounter);
         }else{
             System.out.println("Trucks have average horsepower of: 0.00.");
         }
    }
}
