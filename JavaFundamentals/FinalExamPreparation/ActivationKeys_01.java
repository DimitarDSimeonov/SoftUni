import java.util.Scanner;

public class ActivationKeys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder keyBuild = new StringBuilder(key);

        while (!input.equals("Generate")){
            if(input.contains("Contains")){
                String substring = input.split(">>>")[1];
                if(keyBuild.toString().contains(substring)){
                    System.out.printf("%s contains %s%n",keyBuild, substring);
                }else{
                    System.out.println("Substring not found!");
                }

            }else if(input.contains("Flip")){
                String command = input.split(">>>")[1];
                int startIndex = Integer.parseInt(input.split(">>>")[2]);
                int endIndex = Integer.parseInt(input.split(">>>")[3]);
                String element = keyBuild.substring(startIndex,endIndex);

                if(command.equals("Upper")){
                    element = element.toUpperCase();
                    keyBuild.replace(startIndex, endIndex, element);
                    System.out.println(keyBuild);

                }else if(command.equals("Lower")){
                    element = element.toLowerCase();
                    keyBuild.replace(startIndex, endIndex, element);
                    System.out.println(keyBuild);
                }

            }else if(input.contains("Slice")){
                int startIndex = Integer.parseInt(input.split(">>>")[1]);
                int endIndex = Integer.parseInt(input.split(">>>")[2]);
                keyBuild.delete(startIndex, endIndex);
                System.out.println(keyBuild);

            }

            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n",keyBuild);
    }
}
