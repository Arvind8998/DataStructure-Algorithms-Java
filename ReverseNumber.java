import java.util.*;

public class Main {

    public static void reverseNumber(int num) {
        while (num != 0) {
            int rem = num % 10;
            num /= 10;
            System.out.println(rem);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        reverseNumber(n);

        // write your code here
    }
}