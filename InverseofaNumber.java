import java.util.*;

public class Main{

public static Scanner scn = new Scanner(System.in);

public static void invereseofNumber(int n){
  int op = 1, inv = 0;
  while(n!=0){
      int od = n%10;
      int id = op;
      int ip  = od;
      inv += (int)id*(Math.pow(10, ip-1));
      n /=10;
      op++;
  }
  System.out.println(inv);
}

public static void main(String[] args) {
  int n = scn.nextInt();
  invereseofNumber(n);
  
 }
}