import java.io.*;
import java.util.*;

public class Main {

    public static void printElementRange(int i, int j, int[] arr) {
        for (int idx = i; idx <= j; idx++) {
            System.out.print(arr[idx] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                printElementRange(i, j, arr);
            }
        }
    }

}