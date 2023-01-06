import java.io.*;
import java.util.*;

public class WavePattern {

    public static Scanner scanner = new Scanner(System.in);

    public static void input2dArr(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];

        input2dArr(arr);

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.println(arr[i][j]);
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }

}