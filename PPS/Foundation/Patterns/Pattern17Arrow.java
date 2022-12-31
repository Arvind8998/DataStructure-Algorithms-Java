import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nst = 1, nsp = n / 2;
        for (int row = 1; row <= n; row++) {
            for (int csp = 1; csp <= nsp; csp++) {
                if (row == (n / 2) + 1) {
                    System.out.print("*\t");

                } else {
                    System.out.print("\t");
                }
            }

            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*\t");
            }

            System.out.println();
            if (row <= n / 2) {
                nst++;
            } else {
                nst--;
            }
        }
    }
}