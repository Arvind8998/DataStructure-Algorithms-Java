import java.util.*;

// DigitsofANumber
public class Main {
    public static int powerEqualDigit(int n) {
        int pow = 1;
        n /= 10;

        while (n != 0) {
            pow *= 10;
            n /= 10;
        }
        return pow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pow = powerEqualDigit(n);

        while (pow != 0) {
            int quo = n / pow;
            n %= pow;
            pow /= 10;
            System.out.println(quo);
        }

    }
}