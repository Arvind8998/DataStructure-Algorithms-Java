import java.util.Scanner;

public class AnyBaseAddition {

public static Scanner scn = new Scanner(System.in);

    public static int AnyBaseAddition(int n, int m, int b){
        int pow = 1;
        int carry = 0, ans = 0;
     
        while(n !=0 || m !=0 || carry !=0){
            int sum = carry + n%10 + m%10;
            n /= 10;
            m /= 10;
            int digit = sum%b;
            carry = sum /b;
     
            ans += digit*pow;
            pow *= 10;
        }
        return ans;
    }

    public static void main(String[] args){
        int n = scn.nextInt();
        int m = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(AnyBaseAddition(n, m, b));
    }
}
