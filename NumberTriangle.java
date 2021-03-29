import java.util.*;
public class NumberTriangle {
    public static Scanner scr = new Scanner(System.in);
    public static void printTriangle(int n){
        int nst = 1;
        int val = 1;
        for(int row=1; row <=n; row++){
            for(int cst=1; cst <=nst; cst++){
                System.out.print(val++ + "\t");
            }
            nst++;
            System.out.println();
        }
    }
public static void main(String[] args) {
    int n = scr.nextInt();
    printTriangle(n);
}
}
