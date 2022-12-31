
import java.util.*;

public class Prime {

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int num = scanner.nextInt();
            boolean res = isPrime(num);

            if (res) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }

        // write ur code here

    }
}