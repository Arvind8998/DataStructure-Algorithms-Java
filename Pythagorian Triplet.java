import java.util.*;
  
  public class Main{
  
  public static Scanner scr = new Scanner(System.in);
  
    public static boolean checkPythagorianTriplet(int a, int b, int c){
          if(a > b && a> c && (a*a == b*b + c*c ) || (b > a && b> c && (b*b == b*a + c*c )) || (c > a && c> b && (c*c == a*a + b*b ))){
        return true;
    }
    return false;
        
    }
  
  public static void main(String[] args) {
      
    int a = scr.nextInt();
    int b = scr.nextInt();
    int c = scr.nextInt();
    
    System.out.println(checkPythagorianTriplet(a,b,c));
  
   }
  }