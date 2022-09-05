import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e-> Integer.parseInt(e)).toArray();
        String[] commands = scanner.nextLine().split(" ");

        while (!commands[0].equals("end")){
            switch (commands[0]){
                case "swap":
                    int firstIndex = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);
                    int firstNum = array[firstIndex];
                    int secondNum = array[secondIndex];
                    array[firstIndex] = secondNum;
                    array[secondIndex] = firstNum;
                    break;
                case "multiply":
                    int firstIndexx = Integer.parseInt(commands[1]);
                    int secondIndexx = Integer.parseInt(commands[2]);
                    array[firstIndexx] = array[firstIndexx] * array[secondIndexx];
                    break;
                case "decrease":
                    for (int i = 0; i <= array.length - 1 ; i++) {
                        array[i] -= 1;
                    }
                    break;

            }

            commands = scanner.nextLine().split(" ");
        }
        for (int element = 0; element<= array.length - 1; element++){
            if(element != array.length -1) {
                System.out.print(array[element] + "," + " ");
            }else{
                System.out.print(array[element] + " ");
            }
        }
    }
}
