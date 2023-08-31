import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn  =new Scanner(System.in);

    public static void main(String[] args) {
            int n = scn.nextInt();
            int nst =1, nsp=2*n-3;

            for(int row=1; row<=n; row++){
                int val = 1;
                for(int cst=1; cst<= nst; cst++){
                    System.out.print(val++ +" ");
                }
                for(int csp=1; csp<=nsp; csp++){
                    System.out.print("  ");
                }
                 for(int cst=1; cst<= nst; cst++){
                if(row ==n & cst ==1){
                    val--;
                    continue;
                }
                System.out.print(--val + " ");
            }
                System.out.println();
                nst +=1;
                nsp -=2;
            }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}