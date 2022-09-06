import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String name = input[1];

            if (command.equals("register")){
                String plate = input[2];
                if(!register.containsKey(name)){
                    register.put(name, plate);
                    System.out.printf("%s registered %s successfully%n",name, plate);
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n",register.get(name));
                }

            }else if(command.equals("unregister")){
                if (register.containsKey(name)){
                    register.remove(name);
                    System.out.printf("%s unregistered successfully%n",name);
                }else {
                    System.out.printf("ERROR: user %s not found%n",name);
                }

            }
        }
        for (Map.Entry<String, String> entry : register.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(), entry.getValue());
        }

    }
}
