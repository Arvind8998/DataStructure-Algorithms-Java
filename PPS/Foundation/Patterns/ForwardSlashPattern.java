import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (row + col == n+1) {
                    System.out.print("*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}