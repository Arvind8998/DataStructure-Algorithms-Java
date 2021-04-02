import java.util.*;

public class Main {
    
    public static  Scanner scn = new Scanner(System.in);
    
    public static void printBinomianlPattern(int n){
        for(int i=0; i<n; i++){
            int ncr =1;
            for(int j=0; j<=i; j++){
                System.out.print(ncr + "\t");
                int ncr1 = ((i-j)*ncr)/(j+1);
                ncr = ncr1;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int n = scn.nextInt();
        printBinomianlPattern(n);
    }
}