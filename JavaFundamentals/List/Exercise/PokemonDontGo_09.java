import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distance = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int sumOfRemovedElements = 0;

        while (distance.size() != 0){
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0){
                int firstElement = distance.get(0);
                sumOfRemovedElements += firstElement;
                distance.remove(0);
                distance.add(0, distance.get(distance.size() - 1));
                increasedAndDecreaseElements(distance,firstElement);
            }else if (index > distance.size() - 1){
                int lastElement = distance.get(distance.size() - 1);
                sumOfRemovedElements += lastElement;
                distance.remove(distance.size() - 1);
                distance.add(distance.get(0));
                increasedAndDecreaseElements(distance,lastElement
                );
            }else if(index >= 0 && index < distance.size()) {

                int element = distance.get(index);
                sumOfRemovedElements += element;
                distance.remove(index);
                increasedAndDecreaseElements(distance,element);

            }

        }
        System.out.println(sumOfRemovedElements);
    }
    public static void increasedAndDecreaseElements (List<Integer> list,int element){
        for (int i = 0; i < list.size(); i++) {
            if (element >= list.get(i)) {
                list.set(i, list.get(i) + element);
            } else {
                list.set(i, list.get(i) - element);
            }
        }
    }
}

