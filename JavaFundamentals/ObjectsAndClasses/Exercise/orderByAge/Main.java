package orderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Client> clientsList = new ArrayList<>();

        while (!input.equals("End")){
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Client client = new Client(name, id, age);
            clientsList.add(client);


            input = scanner.nextLine();
        }

        clientsList.sort(Comparator.comparing(Client::getAge));

        for (Client client : clientsList){
            System.out.println(client.toString());
        }

    }
}
