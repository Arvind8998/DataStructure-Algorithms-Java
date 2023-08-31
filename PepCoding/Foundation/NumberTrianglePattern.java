import java.util.*;

public class NumberTrianglePattern {
    
    public static Scanner scn = new Scanner(System.in);
    
    public static void printNumberTriangle(int n){
        int nst = 1;
        int val =1;
        for(int row=1; row<=n; row++){
            for(int cst=1; cst<= nst; cst++){
                System.out.print( val++ + "\t" );
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