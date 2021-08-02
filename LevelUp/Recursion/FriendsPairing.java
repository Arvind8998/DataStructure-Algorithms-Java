import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void pairFriends(int count, int n, boolean[] used, String asf) {
    if(count == n){
        System.out.println(counter++ + "." + asf);
        return;
    }
    int fup = 1; // first unused person

    while(fup <= n && used[fup]) fup++;

    used[fup] = true;
    pairFriends(count+1, n, used, asf + "(" + fup + ") ");

    // pp pairig person
    for(int pp = fup+1; pp <=n; pp++){
        if(!used[pp]){
            used[pp] = true;
            pairFriends(count+2, n, used, asf + "(" + fup + "," + pp + ") ");
            used[pp] = false;
        }
        
    }

    used[fup] = false;
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    pairFriends(0, n, used, "");
  }
}
