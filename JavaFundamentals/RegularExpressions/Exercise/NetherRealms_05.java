import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonList = Arrays.stream( scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());

        for (int i = 0; i < demonList.size(); i++) {
            String demonName = demonList.get(i);
            int demonHealthSum = 0;

            Pattern patternHealth = Pattern.compile("[^0-9+\\-*\\/.]");
            Matcher matcherHealth = patternHealth.matcher(demonName);
            while (matcherHealth.find()){
                String demonHealth = matcherHealth.group();
                for (int j = 0; j < demonHealth.length(); j++) {
                    char current = demonHealth.charAt(j);
                    demonHealthSum += (int) current;
                }
            }

            double demonDamageSum = 0;

            Pattern patternDamage = Pattern.compile("\\-?\\+?[0-9]+[\\.]?[0-9]*");
            Matcher matcherDamage = patternDamage.matcher(demonName);
            while (matcherDamage.find()){
                double damage = Double.parseDouble(matcherDamage.group());
                demonDamageSum += damage;
            }

            for (int j = 0; j < demonName.length(); j++) {
                char current = demonName.charAt(j);
                if (current == '*' && demonDamageSum > 0){
                    demonDamageSum *= 2;
                }else  if (current == '/' && demonDamageSum > 0){
                    demonDamageSum /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n",demonName, demonHealthSum, demonDamageSum);
        }
    }
}
