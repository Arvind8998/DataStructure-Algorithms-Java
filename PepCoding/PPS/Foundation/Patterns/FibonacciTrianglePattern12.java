import java.util.*;

public class FibonacciTrianglePattern12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int row = 0; row < n; row++) {
            int ncr = 1;
            for (int col = 0; col <= row; col++) {
                System.out.print(ncr + "\t");
                int ncr1 = ((row - col) * ncr) / (col + 1);
                ncr = ncr1;
            }
            System.out.println("");
        }
    }
}