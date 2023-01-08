import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void input2dArr(int[][] arr, int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static void getSpiralMatrixPrint(int[][] arr, int n, int m) {
        int nCell = n * m;
        int rmin = 0, cmin = 0, rmax = n - 1, cmax = m - 1;
        while (nCell > 0) {
            for (int r = rmin; r <= rmax && nCell > 0; r++) {
                System.out.println(arr[r][cmin]);
                nCell--;
            }
            cmin++;

            for (int c = cmin; c <= cmax && nCell > 0; c++) {
                System.out.println(arr[rmax][c]);
                nCell--;
            }
            rmax--;

            for (int r = rmax; r >= rmin && nCell > 0; r--) {
                System.out.println(arr[r][cmax]);
                nCell--;
            }
            cmax--;

            for (int c = cmax; c >= cmin && nCell > 0; c--) {
                System.out.println(arr[rmin][c]);
                nCell--;
            }
            rmin++;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        input2dArr(arr, n, m);
        getSpiralMatrixPrint(arr, n, m);
    }

}