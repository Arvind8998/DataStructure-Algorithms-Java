import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
    
        int on1 = n1, on2 = n2;
        
        while (n1 % n2 != 0) {
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }

        int gcd = n2;

        int lcm = (on1 * on2) / gcd;

        System.out.print(gcd + "\n");
        System.out.print(lcm + "\n");
    }
}