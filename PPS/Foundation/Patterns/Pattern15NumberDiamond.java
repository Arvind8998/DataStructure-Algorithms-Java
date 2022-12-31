import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int nst = 1, val = 1, nsp = n / 2;
        for (int row = 1; row <= n; row++) {

            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }

            int cval = val;
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(cval + "\t");

                if (cst <= (nst / 2)) {
                    cval++;
                } else {
                    cval--;
                }
            }

            System.out.println();

            if (row <= n / 2) {
                val++;
                nst += 2;
                nsp--;
            } else {
                val--;
                nst -= 2;
                nsp++;
            }
        }
    }
}