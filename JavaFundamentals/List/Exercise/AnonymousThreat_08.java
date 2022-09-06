import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("3:1")){
            String command = input.split(" ")[0];
            switch (command){
                case "merge":
                    int start = Integer.parseInt(input.split(" ")[1]);
                    int end = Integer.parseInt(input.split(" ")[2]);

                    if (start < 0){
                        start = 0;
                    }

                    if(end > list.size() - 1){
                        end = list.size() - 1;
                    }

                    if(start < list.size() - 1 && end >= 0 && start < end){
                        String result = "";
                        for (int i = start; i <= end ; i++) {
                            result += list.get(i);
                        }
                        for (int i = start; i <= end ; i++) {
                            list.remove(start);
                        }
                        list.add(start, result);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int delimiter = Integer.parseInt(input.split(" ")[2]);

                    String elementForDivide = list.get(index);
                    list.remove(index);

                    int partSize = elementForDivide.length() / delimiter;
                    
                    int startIndex = 0;

                    for (int i = 1; i < delimiter; i++) {
                        list.add(index , elementForDivide.substring(startIndex, startIndex + partSize));
                        index++;
                        startIndex += partSize;
                    }
                    list.add(index, elementForDivide.substring(startIndex));
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", list));
    }
}
