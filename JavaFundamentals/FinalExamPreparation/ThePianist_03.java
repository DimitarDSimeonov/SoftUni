import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List <String>> pieceCollection = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            //"{piece}|{composer}|{key}
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            pieceCollection.put(piece, new ArrayList<>());
            pieceCollection.get(piece).add(composer);
            pieceCollection.get(piece).add(key);
        }
        String command = scanner.nextLine();

        while (!command.equals("Stop")){
           if(command.contains("Add")){ //Add|{piece}|{composer}|{key}
               String piece = command.split("\\|")[1];
               String composer = command.split("\\|")[2];
               String key = command.split("\\|")[3];

               if(pieceCollection.containsKey(piece)){
                   System.out.println(piece + " is already in the collection!");
               }else{
                   pieceCollection.put(piece, new ArrayList<>());
                   pieceCollection.get(piece).add(composer);
                   pieceCollection.get(piece).add(key);
                   System.out.printf("%s by %s in %s added to the collection!%n",piece, composer, key);
               }
           }else if(command.contains("Remove")){ //Remove|{piece}"
               String piece = command.split("\\|")[1];
               if(pieceCollection.containsKey(piece)){
                   pieceCollection.remove(piece);
                   System.out.printf("Successfully removed %s!%n",piece);
               }else{
                   System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
               }
           }else if (command.contains("ChangeKey")){ //ChangeKey|{piece}|{new key}
               String piece = command.split("\\|")[1];
               String newKey = command.split("\\|")[2];
               if(pieceCollection.containsKey(piece)){
                   pieceCollection.get(piece).set(1, newKey);
                   System.out.printf("Changed the key of %s to %s!%n",piece, newKey);
               }else{
                   System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
               }
           }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : pieceCollection.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
