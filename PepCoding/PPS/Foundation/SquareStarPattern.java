import java.util.Scanner;

public class SquareStarPattern {
    public static void getSquarePattern(int n) {
        int nst = 5;

        for (int row = 1; row <= n; row++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*");
            }
            System.out.println();
            nst = n;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getSquarePattern(n);
    }
}
