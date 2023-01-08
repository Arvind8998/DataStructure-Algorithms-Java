import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void input2dArray(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static void gapStrategy(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; i < n && j < m; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n = scanner.nextInt();

        int[][] arr = new int[n][n];

        input2dArray(arr);
        gapStrategy(arr);
    }

}