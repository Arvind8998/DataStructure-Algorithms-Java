import java.util.*;
public class InvertedStarTriangle {
    public static Scanner scr = new Scanner(System.in);
    public static void invertedTriangle(int n){
        int nst = n;
        for(int row=1; row <=n; row++){
            for(int cst=1; cst <=nst; cst++){
                System.out.print("*\t");
            }
            nst--;
            System.out.println();
        }
    }
public static void main(String[] args) {
    int n = scr.nextInt();
    invertedTriangle(n);
}
}