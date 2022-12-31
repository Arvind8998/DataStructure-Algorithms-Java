import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= n; col++) {

                if (row == 1) {
                    if (col == n || col <= n / 2 + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else if (row <= n / 2) {
                    if (col == n || col == n / 2 + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }

                else if (row == n / 2 + 1) {
                    System.out.print("*\t");
                }

                else if (row < n) {
                    if (col == 1 || col == n / 2 + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                } else {
                    if (col == 1 || col >= n / 2 + 1) {
                        System.out.print("*\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println("");

        }
    }
}