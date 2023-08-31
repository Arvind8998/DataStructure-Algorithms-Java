import java.io.*;
import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String ans) {
        if(n==0){
            System.out.println(ans);
            return;
        }
        
        for(int jump=1; jump<=3 && n-jump >=0; jump++){
            printStairPaths(n-jump, ans +jump);
        }
    }

}