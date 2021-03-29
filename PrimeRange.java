import java.util.*;

public class Main{
    public static Scanner scn = new Scanner(System.in);
     public static boolean isPrime(int n){
            for(int start=2; start*start<=n; start++){
                if(n%start ==0){
                    return false;
                }
            }
            return true;
        }
        
    public static void primeRange(int low, int high){
        for(int start=low; start<= high; start++){
            boolean res = isPrime(start);
            if(res == true){
                System.out.println(start);
            }
        }
    }
    
    
    public static void main(String[] args) {
        int low = scn.nextInt();
        int high = scn.nextInt();
       primeRange(low, high);
    }
}