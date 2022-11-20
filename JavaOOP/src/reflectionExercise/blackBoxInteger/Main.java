package reflectionExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] commandInfo = input.split("_");
            String commandName = commandInfo[0];
            int value = Integer.parseInt(commandInfo[1]);

            Method method = blackBoxInt.getClass().getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(field.get(blackBoxInt));

            input = scanner.nextLine();
        }

    }
}
