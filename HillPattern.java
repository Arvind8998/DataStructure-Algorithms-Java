import java.util.*;

public class HillPattern {
    public static Scanner scn = new Scanner(System.in);

    public static void printHillPattern(int n) {
        int nsp = 2*n -3; 
        int nst=1;
        
        for(int row=1; row<= n; row++){
            int val =1;
            for(int cst=1; cst<= nst; cst++){
                System.out.print(val++ + "\t");
            }
            
            for(int csp=1; csp<= nsp; csp++){
                System.out.print("\t");
            }
            
            for(int cst=1; cst<= nst; cst++){
                if(row ==n & cst ==1){
                    val--;
                    continue;
                }
                System.out.print(--val + "\t");
            }
            
            nst++;
            nsp -=2;
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        printHillPattern(n);
    }
}