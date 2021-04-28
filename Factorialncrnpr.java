import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    
    public static int factorial(int n){
        return n==0 ? 1 : n*factorial(n-1);
    }
    
    public static void main(String[] args) {
        int n = scn.nextInt();
        int r = scn.nextInt();
        System.out.println(factorial(n));
        System.out.println(factorial(n)/factorial(n-r));
        System.out.println(factorial(n)/(factorial(n-r)*factorial(r)));
    }
}