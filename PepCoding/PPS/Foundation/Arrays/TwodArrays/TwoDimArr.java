import java.util.*;

public class TwoDimArr {
    public static Scanner scanner = new Scanner(System.in);

    public static void display2DMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
        }
    }

    public static int getMaxValue(int[][] arr) {
        int max = -(int) 1e9;
        int n = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

    public static int getMinValue(int[][] arr) {
        int min = -(int) 1e9;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(min, arr[i][j]);
            }
        }
        return min;
    }

    public static boolean find(int[][] arr, int data) {
        boolean res = false;
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = data == arr[i][j];
            }
        }
        return res;
    }

    public static void input(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i] = scanner.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        int rows = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[rows][col];
        display2DMatrix(arr);
    }
}
