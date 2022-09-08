import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> attackList = new ArrayList<>();
        List<String> destroyedList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String massages = scanner.nextLine();

            //[s, t, a, r]
            StringBuilder massagesBuild = new StringBuilder(massages);
            int keyCount = 0;
            for (int index = 0; index < massagesBuild.length(); index++) {
                char currentChar = massagesBuild.charAt(index);
                if(currentChar == 's' || currentChar == 'S' || currentChar == 't' || currentChar == 'T' ||
                   currentChar == 'a' || currentChar == 'A' || currentChar == 'r' || currentChar == 'R'){
                    keyCount++;
                }
            }
            for (int index = 0; index < massagesBuild.length(); index++) {
                char currentChar = massagesBuild.charAt(index);
                char newChar = (char) (currentChar - keyCount);
                massagesBuild.replace(index, index + 1, newChar + "");
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<typeAttack>[A|D])[^@\\-!:>]*![^@\\-!:>]*->[^@\\-!:>]*?(?<solders>[0-9]+)");
            Matcher matcher = pattern.matcher(massagesBuild);

            if (matcher.find()){
                String name = matcher.group("name");
                String typeAttack = matcher.group("typeAttack");
                if(typeAttack.equals("A")){
                    attackList.add(name);
                }else{
                    destroyedList.add(name);
                }

            }

        }
        attackList.sort(String::compareTo);
        destroyedList.sort(String::compareTo);

        System.out.printf("Attacked planets: %d%n",attackList.size());
        if (attackList.size() > 0){
            for(String e : attackList){
                System.out.printf("-> %s%n",e);
            }
        }
        System.out.printf("Destroyed planets: %d%n",destroyedList.size());
        if ( destroyedList.size() > 0){
            for(String e : destroyedList){
                System.out.printf("-> %s%n",e);
            }
        }
    }
}
