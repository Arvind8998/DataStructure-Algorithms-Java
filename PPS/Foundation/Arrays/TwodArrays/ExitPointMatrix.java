import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void input2dArray(int[][] arr, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static void getExitPointOfMatrix(int[][] arr, int n, int m) {
        int noOfEle = n * m;
        int dir = 0, i = 0, j = 0;
        while (true) {
            dir += arr[i][j] % 4;

            if (dir == 0) {// East
                j++;
                if (j == m) {
                    System.out.println(i + "\n" + (j - 1));
                    break;
                }
            } else if (dir == 1) {// South
                i++;
                if (i == n) {
                    System.out.println(i - 1 + "\n" + j);
                    break;
                }
            } else if (dir == 2) {// West
                j--;
                if (j == -1) {
                    System.out.println(i + "\n" + j + 1);
                    break;
                }
            } else if (dir == 3) { // North
                i--;
                if (i == -1) {
                    System.out.println(i + 1 + "\n" + j);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        input2dArray(arr, n, m);
        getExitPointOfMatrix(arr, n, m);
    }

}