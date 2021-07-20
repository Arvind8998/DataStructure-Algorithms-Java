import java.util.*;

public class DiamondOutInSpace {
    public static Scanner scn = new Scanner(System.in);

    public static void printDiamondPattern(int n) {
        int nspO = n/2;
        int nspI = -1;

        for (int row = 1; row <= n; row++) {

            for (int cspO = 1; cspO <= nspO; cspO++) {
                System.out.print("\t");
            }
            System.out.print("*\t");


            for (int cspI = 1; cspI <= nspI; cspI++) {
                System.out.print("\t");
            }

            if(nspI != -1)
            System.out.print("*\t");

            if (row <= n / 2) {
                nspO--;
                nspI += 2;
            } else {
                nspO++;
                nspI -= 2;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        printDiamondPattern(n);

    }
}