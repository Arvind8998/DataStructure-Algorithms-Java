import java.util.*;
   
   public class Main{
   public static Scanner scs = new Scanner(System.in);
    public static int countDigits(int n){
          int len = 0;
          while(n != 0){
              n /= 10;
              len += 1;
          }
          return len;
      }
   public static void main(String[] args) {
     int n = scs.nextInt();
      System.out.println(countDigits(n));
    }
   }