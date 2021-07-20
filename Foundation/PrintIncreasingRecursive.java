import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        printDecreasing(n,1);
    }

    public static void printDecreasing(int n, int b){
        if(b > n){
            return;
        }
        System.out.println(b); 
        printDecreasing(n,b+1);
    }

}