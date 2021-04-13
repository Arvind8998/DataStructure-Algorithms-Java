import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        return n== 0 ? 1 : n*factorial(n-1);
    }

}