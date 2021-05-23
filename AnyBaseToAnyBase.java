import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static Scanner scn = new Scanner(System.in);

    public static int anyBaseTodecimal(int n, int b){
        int ans= 0;
        int pow = 1;
        while(n !=0){
            int rem = n%10;
            n = n/10;
            
            ans += rem*pow;
            pow *= b;
        }
        return ans;
    }

    public static int decimaltoAnyBase(int n, int b){
        int ans= 0;
        int pow = 1;
        while(n !=0){
            int rem = n%b;
            n = n/b;
            
            ans += rem*pow;
            pow *= 10;
        }
        return ans;
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        int deciamlNum = anyBaseTodecimal(n,b1);
        int res = decimaltoAnyBase(deciamlNum,b2);
        System.out.print(res);

    }
}
