import java.io.*;
 import java.util.*;
 public class Main {
     public static Scanner scr = new Scanner(System.in);
     public static void printTriangle(int n){
         int nst = 1;
         int nsp = n-1;
         for(int row=1; row <=n; row++){
             for(int csp=1; csp <= nsp; csp++){
                 System.out.print("\t");
             }
             for(int cst=1; cst <=nst; cst++){
                 System.out.print("*\t");
             }
             nst++;
             nsp--;
             System.out.println();
         }
     }
 public static void main(String[] args) {
     int n = scr.nextInt();
     printTriangle(n);
 }
 }
