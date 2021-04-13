import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        int x = scn.nextInt();
        int n = scn.nextInt();
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        int recAns = power(x,n-1);
        int ans = x*recAns;
        return ans;
    }

}