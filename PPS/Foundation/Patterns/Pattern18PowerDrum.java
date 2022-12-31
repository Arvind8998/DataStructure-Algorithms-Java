import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nsp = 0, nst = n;
        for (int row = 1; row <= n; row++) {
            for (int csp = 1; csp <= nsp; csp++) {

                System.out.print("\t");
            }
            for (int cst = 1; cst <= nst; cst++) {
                if (row > 1 && row <= n / 2 && cst > 1 && cst < nst) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }

            }
            System.out.println();
            if (row <= n / 2) {
                nst -= 2;
                nsp++;
            } else {
                nst += 2;
                nsp--;
            }

        }
    }
}