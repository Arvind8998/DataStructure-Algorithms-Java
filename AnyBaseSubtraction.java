import java.util.*;
import java.io.*;

public class AnyBaseSubtraction {

public static Scanner scn = new Scanner(System.in);

    public static int AnyBaseSubtractionGetter(int b, int n, int m){
        int pow = 1;
        int borrow = 0, res = 0;
     
        while(m !=0){
            int diff = borrow + m%10 - n%10;
            n /= 10;
            m /= 10;

            if(diff <0){
                diff += b;
                borrow = -1;
            }
            else{
                borrow = 0;
            }
     
            res += diff*pow;
            pow *= 10;
        }
        return res;
    }

    public static void main(String[] args){
        int b = scn.nextInt();
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(AnyBaseSubtractionGetter(b, n, m));
    }
   
}
