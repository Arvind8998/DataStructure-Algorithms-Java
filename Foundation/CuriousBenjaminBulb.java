import java.util.*;
  
  public class CuriousBenjaminBulb{
  public static Scanner scr = new Scanner(System.in);
  public static void benjaminBulb(int n){
      for(int i = 1; i*i <= n; i++){
          System.out.println(i*i);
      }
  }
  public static void main(String[] args) {
    int n = scr.nextInt();
    benjaminBulb(n);
   }
  }