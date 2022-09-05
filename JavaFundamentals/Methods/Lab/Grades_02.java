import java.util.Scanner;

public class Grades_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        printGrade(grade);

    }

    private static void printGrade ( double grade){
        //•	2.00 – 2.99 - "Fail"
        //•	3.00 – 3.49 - "Poor"
        //•	3.50 – 4.49 - "Good"
        //•	4.50 – 5.49 - "Very good"
        //•	5.50 – 6.00 - "Excellent"
        if (grade >= 2.00 && grade <= 2.99){
            System.out.println("Fail");

        }else if (grade >= 3.00 && grade <= 3.49){
            System.out.println("Poor");

        }else if (grade >= 3.50 && grade <= 4.49){
            System.out.println("Good");

        }else if (grade >= 4.50 && grade <= 5.49){
            System.out.println("Very good");

        }else if (grade >= 5.50 && grade <= 6.00){
            System.out.println("Excellent");
        }
    }
}
