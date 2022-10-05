package definingClassesExercise.rawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            int power = Integer.parseInt(input[2]);
            String cargoType = input[4];
            double[] pressure = new double[4];
            pressure[0] = Double.parseDouble(input[5]);
            pressure[1] = Double.parseDouble(input[7]);
            pressure[2] = Double.parseDouble(input[9]);
            pressure[3] = Double.parseDouble(input[11]);

            cars.add(new Car(name, power, cargoType, pressure));
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                for (Car car : cars){
                    if(car.getCargoType().equals(command)){
                       for (double tire : car.getPressure()){
                           if(tire < 1){
                               System.out.println(car.getModel());
                               break;
                           }
                       }
                    }
                }
                break;
            case "flamable":
                for (Car car : cars){
                    if(car.getCargoType().equals(command) && car.powerIsGood(car.getPower())){
                        System.out.println(car.getModel());
                    }
                }
                break;
        }
    }
}
