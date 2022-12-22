import java.util.*;

public class Main {

    // public static int myPower(int n){
    // int pow = 1;

    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int inverse = 0;
        int origPlace = 1;

        while (n != 0) {
            int origDigit = n % 10;

            int invDigit = origPlace;
            int invPlace = origDigit;

            inverse = inverse + invDigit * (int) (Math.pow(10, invPlace - 1));

            // Updating original place and reduicing values
            n /= 10;
            origPlace++;
        }
        System.out.println(inverse);
    }
}