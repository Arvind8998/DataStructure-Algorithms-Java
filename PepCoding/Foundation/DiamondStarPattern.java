import java.util.*;

public class DiamondStarPattern {
    public static Scanner scn = new Scanner(System.in);
    
    public static void printDiamondPattern(int n){
        int nst = 1;
        int nsp = n/2;
        
        for(int row=1; row <=n; row++){
            for(int csp =1; csp <=nsp; csp++){
                System.out.print("\t");
            }
            
            for(int cst =1; cst <=nst; cst++){
                System.out.print("*\t");
            }
            
            if(row <= n/2){
                nsp--; 
                nst += 2;
            }
            else{
                nsp++;
                nst -=2;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int n = scn.nextInt();
        printDiamondPattern(n);
        

    }
}