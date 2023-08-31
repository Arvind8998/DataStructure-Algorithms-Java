import java.util.*;

public class NumberPatternPyramid {
    public static Scanner scn = new Scanner(System.in);

    public static void printDiamondPattern(int n) {
        int nst = 1;
        int nsp = n / 2;

        for (int row = 1; row <= n; row++) {

            for (int csp = 1; csp <= nsp; csp++) {
                System.out.print("\t");
            }
            int val = row;

            if (row > n / 2 +1) {
                val = n - row + 1;
            }
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print(val + "\t");
                if(cst <= nst/2) val++;
                else val--;
            }

            if (row <= n / 2) {
                nsp--;
                nst += 2;
            } else {
                nsp++;
                nst -= 2;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        printDiamondPattern(n);

    }
}