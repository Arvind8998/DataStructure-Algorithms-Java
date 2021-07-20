import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void printInvertedSpaceTriangle(int n){
        int nst = n;
        int nsp = 0;
        
        for(int row=1; row <= n; row++){
            
            for(int csp =1; csp <= nsp; csp++){
                System.out.print("\t");
            }
            
            for(int cst =1; cst <= nst; cst++){
                System.out.print("*\t");
            }
            System.out.println();
            
            nst--;
            nsp++;
        }
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        printInvertedSpaceTriangle(n);
    }
}