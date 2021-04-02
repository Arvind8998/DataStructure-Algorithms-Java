import java.util.*;

public class SquarePattern{

public static Scanner scn = new Scanner(System.in);

public static void printSquare(int n){
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
        System.out.print("*\t");
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    int n = scn.nextInt();
    printSquare(n);

 }
}