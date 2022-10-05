package definingClassesExercise.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineInfo = scanner.nextLine().split("\\s+");

            String model = engineInfo[0];
            String power = engineInfo[1];

            switch (engineInfo.length){
                case 2:
                    engineList.add(new Engine(model, power));
                    break;
                case 3:
                    char[] info = engineInfo[2].toCharArray();
                    if(Character.isDigit(info[0])){
                        int displacement = Integer.parseInt(engineInfo[2]);
                        engineList.add(new Engine(model, power, displacement));
                    }else{
                        String efficiency = engineInfo[2];
                        engineList.add(new Engine(model, power, efficiency));
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(engineInfo[2]);
                    String efficiency = engineInfo[3];
                    engineList.add(new Engine(model, power, displacement, efficiency));
                    break;
            }
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            String carModel = carInfo[0];
            Engine engine = engineList.stream().filter(e -> e.getEngineModel().equals(carInfo[1])).findFirst().get();

            switch (carInfo.length){
                case 2:
                    carList.add(new Car(carModel, engine));
                    break;
                case 3:
                    char[] info = carInfo[2].toCharArray();
                    if(Character.isDigit(info[1])){
                        int weight = Integer.parseInt(carInfo[2]);
                        carList.add(new Car(carModel, engine, weight));
                    }else{
                        String color = carInfo[2];
                        carList.add(new Car(carModel, engine, color));
                    }
                    break;
                case 4:
                    int weight = Integer.parseInt(carInfo[2]);
                    String color = carInfo[3];
                    carList.add(new Car(carModel, engine, weight, color));
                    break;
            }
        }

        carList.forEach(e -> System.out.println(e.toString()));
    }
}
