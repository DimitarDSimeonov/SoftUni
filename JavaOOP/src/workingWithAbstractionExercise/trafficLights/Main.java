package workingWithAbstractionExercise.trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split(" ");

        List<TrafficLight> list = new ArrayList<>();

        for (String signal : colors) {
            Color color = Color.valueOf(signal);
            TrafficLight trafficLight = new TrafficLight(color);
            list.add(trafficLight);
        }

        int rotation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotation; i++) {
            for (TrafficLight light : list) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
