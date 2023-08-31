import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nspo = n / 2, nspi = -1;

        for (int row = 1; row <= n; row++) {
            for (int cspo = 1; cspo <= nspo; cspo++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
        }
        
        for (int row = 1; row <= n; row++) {
            for (int cspo = 1; cspo <= nspo; cspo++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
        }

    }
}