import java.util.Scanner;

public class TheatrePromotion_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        if (age >= 0 && age <= 18){
            if (typeDay.equals("Weekday")){
                System.out.println("12$");
            }else if (typeDay.equals("Weekend")){
                System.out.println("15$");
            }else if(typeDay.equals("Holiday")){
                System.out.println("5$");
            }

        }else  if(age > 18 && age <= 64){
            if (typeDay.equals("Weekday")){
                System.out.println("18$");
            }else if (typeDay.equals("Weekend")){
                System.out.println("20$");
            }else if(typeDay.equals("Holiday")){
                System.out.println("12$");
            }

        }else if (age > 64 && age <= 122){
            if (typeDay.equals("Weekday")){
                System.out.println("12$");
            }else if (typeDay.equals("Weekend")){
                System.out.println("15$");
            }else if(typeDay.equals("Holiday")){
                System.out.println("10$");
            }

        }else{
            System.out.println("Error!");

        }
    }
}
