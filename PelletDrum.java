import java.util.*;

public class PelletDrum{

public static Scanner scn = new Scanner(System.in);

public static void printPalletDrum(int n){
    int nst = n;
    int nspo = 0;
    
    for(int row=1; row<=n; row++){
        for(int cspo=1; cspo<= nspo; cspo++){
            System.out.print("\t");
        }
        
        for(int cst=1; cst <=nst; cst++){
            if(row >1 && row <= n/2 && cst >1 && cst < nst){
                System.out.print("\t");
            }
            else{
               System.out.print("*\t"); 
            }
            
        }
        
        if(row <= n/2){
            nst -=2;
            nspo++;
        }
        else{
            nst +=2;
            nspo--;
        }
        
        System.out.println("");
    }
}

public static void main(String[] args) {
   
    int n = scn.nextInt();
    printPalletDrum(n);
    
 }
}