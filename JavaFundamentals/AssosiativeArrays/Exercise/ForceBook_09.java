import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> sideList = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")){

            if (input.contains("|")){
                String side = input.split(" \\| ")[0];
                String name = input.split(" \\| ")[1];

                boolean nameInSide = false;

                if (!sideList.containsKey(side)){
                    sideList.put(side, new ArrayList<>());
                }

                for (List<String> list : sideList.values()){
                    if (list.contains(name)){
                        nameInSide = true;
                        break;
                    }
                }
                if(!nameInSide){
                    sideList.get(side).add(name);
                }

            }else if (input.contains("->")){
                String name = input.split(" -> ")[0];
                String side = input.split(" -> ")[1];

                sideList.entrySet().forEach(entry -> entry.getValue().remove(name));

                if(!sideList.containsKey(side)){
                    sideList.put(side, new ArrayList<>());
                    sideList.get(side).add(name);
                }else {
                    sideList.get(side).add(name);
                }
                System.out.printf("%s joins the %s side!%n",name ,side);
            }



            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : sideList.entrySet()) {
            if (entry.getValue().size() > 0){
                System.out.printf("Side: %s, Members: %d%n",entry.getKey(), entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.printf("! %s%n",entry.getValue().get(i));
                }
            }
        }

    }
}
