import java.util.*;
  
  public class Main{
  
  public static Scanner scn = new Scanner(System.in);
  
  public static void printFibonacci(int n){
      int a =0, b=1, sum = 0;
      for(int i=0; i< n; i++){
          System.out.print(a+"\n");
          
          sum = a+ b;
          a = b;
          b = sum;
          
      }
  }
  
  public static void main(String[] args) {
      int n = scn.nextInt();
      printFibonacci(n);
   }
  }