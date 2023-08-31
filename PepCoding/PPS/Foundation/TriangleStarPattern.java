import java.util.Scanner;

public class TriangleStarPattern {
    public static void getSquarePattern(int n) {
        int nst = 1;

        for (int row = 1; row <= n; row++) {
            for (int cst = 1; cst <= nst; cst++) {
                System.out.print("*");
            }
            System.out.println();
            nst++;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        getSquarePattern(n);
    }
}
