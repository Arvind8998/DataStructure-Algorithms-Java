import java.util.*;

public class Main {
    public static boolean isPythagorianTriplet(int a, int b, int c) {
        return (a * a + b * b == c * c) || (b * b + c * c == a * a) || (a * a + c * c == b * b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.print(isPythagorianTriplet(a, b, c));

    }
}