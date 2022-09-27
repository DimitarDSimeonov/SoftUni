package setsAndmapsAdvanceLab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Map <String, List<String>>> continentInfo = new LinkedHashMap<>();

        for (int i = 0; i < lines; i++) {

            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if(!continentInfo.containsKey(continent)){
                continentInfo.put(continent, new LinkedHashMap<>());
                continentInfo.get(continent).put(country, new ArrayList<>());
                continentInfo.get(continent).get(country).add(city);
            }else{
                if (!continentInfo.get(continent).containsKey(country)){
                    continentInfo.get(continent).put(country, new ArrayList<>());
                    continentInfo.get(continent).get(country).add(city);
                }else{
                    continentInfo.get(continent).get(country).add(city);
                }
            }
        }
        for (Map.Entry<String, Map<String, List<String>>> entry : continentInfo.entrySet()) {
            System.out.println(entry.getKey() +":");
            for (Map.Entry<String, List<String>> countries : entry.getValue().entrySet()) {
                System.out.printf("%s -> %s%n",countries.getKey(),countries.getValue().toString().replaceAll("[\\[\\]]", ""));
            }

        }

    }
}

