//Complexity -> o(n2)
import java.util.*;

public class FibonacciNoTriangle {
    
    public static Scanner scn = new Scanner(System.in);
    
    public static void printNumberTriangle(int n){
        int nst = 1;
        int a =0, b=1;
        for(int row=1; row<=n; row++){
            for(int cst=1; cst<= nst; cst++){
                System.out.print( a + "\t" );
                int sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println("");
            nst++;
        }
    }

    public static void main(String[] args) {
        
        int n = scn.nextInt();
        printNumberTriangle(n);

    }
}