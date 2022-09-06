import java.util.*;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String , List<String>> companyList = new LinkedHashMap<>();

        while (!input.equals("End")){
            String company = input.split(" -> ")[0];
            String id = input.split(" -> ")[1];

            if(!companyList.containsKey(company)){
                companyList.put(company, new ArrayList<>());
            }
            if(!companyList.get(company).contains(id)){
                companyList.get(company).add(id);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companyList.entrySet()) {
            System.out.printf("%s%n",entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n",entry.getValue().get(i));
            }
        }

    }
}
