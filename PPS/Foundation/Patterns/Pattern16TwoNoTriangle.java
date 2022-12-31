import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nsp = (2 * n) - 3, nst = 1, val = 1;

        for (int row = 1; row <= n; row++) {
            int cval = 1;
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(cval++ + "\t");
            }
            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            if (row == n) {
                nst--;
                cval--;
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(--cval + "\t");
            }
            nst++;
            nsp -= 2;
            System.out.println();

        }
    }
}