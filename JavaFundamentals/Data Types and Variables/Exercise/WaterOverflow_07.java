import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int tank = 255;
        int litreInTank = 0;

        for (int i = 0; i < n; i++) {
            int litre = Integer.parseInt(scanner.nextLine());
            if ( litre <= tank){
                tank -= litre;
                litreInTank += litre;
            }else{
                System.out.println("Insufficient capacity!" );
            }
        }
        System.out.println(litreInTank);
    }
}
