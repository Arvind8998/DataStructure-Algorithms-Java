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
   
   public static int rotateNumber(int n, int r){
       int digits = countDigits(n);
       int mul = 1;
       int div = 1;
       r %= digits;
       if(r < 0){
           r += digits;
       }
       
       for(int i= 1; i<=digits; i++){
           if(i<= r){
               div *= 10;
           }
           else{
               mul *= 10;
           }
       }
       
       int a = n % div;
       int b = n /div;
       return a *mul + b;
       
   }
   
   public static void main(String[] args) {
       int n = scs.nextInt();
       
       int r = scs.nextInt();
       
System.out.println(rotateNumber(n,r));
    }
   }