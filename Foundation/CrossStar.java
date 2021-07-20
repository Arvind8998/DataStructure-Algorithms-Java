import java.util.*;

public class CrossStar {
    public static Scanner scn = new Scanner(System.in);

    public static void backSlashPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i+j == n+1 || i == j){
                    System.out.print("*\t");
                }
                else System.out.print("\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        backSlashPattern(n);

    }
}