import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int nst = 1, nsp=3;
        
        for(int row=1; row<=n; row++){

            for(int csp=0; csp<nsp; csp++){
                System.out.print("  ");
            }
            int val = row;

            for(int cst=1; cst<=nst; cst++){
                if(cst<=(nst/2)){
                    System.out.print(val++ + " ");
                }
                else{
                    System.out.print(val-- + " ");
                }   
            }
            System.out.println();

            nst += 2;
            nsp -=1;
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}