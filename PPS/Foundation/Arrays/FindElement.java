import java.io.*;
import java.util.*;

public class Main {

    public static int findElement(int[] arr, int d) {
        int eleIndex = -1;
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == d) {
                return idx;
            }
        }
        return eleIndex;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();

        int index = findElement(arr, d);
        System.out.println(index);
    }

}