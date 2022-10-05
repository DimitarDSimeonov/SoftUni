package functionalProgramingExercise;

import java.util.*;
import java.util.stream.Collectors;

public class PredicateParty_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>  guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")){
            String command = input.split("\\s+")[0];
            String operation = input.split("\\s+")[1];
            String parameter = input.split("\\s+")[2];

            switch (command){
                case "Remove":
                    remove(guests, operation, parameter);
                    break;
                case "Double":
                    duplication(guests, operation, parameter);
                    break;
            }

            input = scanner.nextLine();
        }

        Collections.sort(guests);

        if(!guests.isEmpty()) {
            System.out.print(String.join(", ", guests) + " are going to the party!");
        }else{
            System.out.println("Nobody is going to the party!");
        }

    }
    public static void remove(List<String> list, String operation, String parameter){
        switch (operation){
            case "StartsWith":
                list.removeIf(e -> e.startsWith(parameter));
                break;
            case "EndsWith":
                list.removeIf(e ->  e.endsWith(parameter));
                break;
            case "Length":
                list.removeIf(e -> e.length() == Integer.parseInt(parameter));
                break;
        }
    }
    public static void duplication(List<String> list, String operation, String parameter){
        List<String> nameToAppend = new ArrayList<>();
        switch (operation){
            case "StartsWith":
                for(String name : list){
                    if(name.startsWith(parameter)){
                        nameToAppend.add(name);
                    }
                }
                list.addAll(nameToAppend);
                break;
            case "EndsWith":
                for(String name : list){
                    if(name.endsWith(parameter)){
                        nameToAppend.add(name);
                    }
                }
                list.addAll(nameToAppend);
                break;
            case "Length":
                for(String name : list){
                    if(name.length() == Integer.parseInt(parameter)){
                        nameToAppend.add(name);
                    }
                }
                list.addAll(nameToAppend);
                break;
        }
    }
}
