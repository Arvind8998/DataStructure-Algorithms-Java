import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nso = n / 2, nsi = -1;

        for (int row = 1; row <= n; row++) {

            for (int cso = 1; cso <= nso; cso++) {
                System.out.print("\t");
            }

            System.out.print("*\t");

            for (int csi = 1; csi <= nsi; csi++) {
                System.out.print("\t");
            }

            if (nsi != -1) {
                System.out.print("*\t");
            }

            System.out.println();

            if (row <= n / 2) {
                nso--;
                nsi += 2;

            } else {
                nso += 1;
                nsi -= 2;
            }

        }

    }
}