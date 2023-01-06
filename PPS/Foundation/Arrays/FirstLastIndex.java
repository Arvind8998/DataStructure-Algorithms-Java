import java.io.*;
import java.util.*;

public class Main {

    public static int getFirstIndex(int[] arr, int d) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == d) {
                if (mid - 1 >= 0 && arr[mid - 1] == d) {
                    ei = mid - 1;
                } else {
                    return mid;
                }

            } else if (arr[mid] < d) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return -1;
    }

    public static int getLastIndex(int[] arr, int d) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == d) {
                if (mid + 1 < n && arr[mid + 1] == d) {
                    si = mid + 1;
                } else {
                    return mid;
                }

            } else if (arr[mid] < d) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();
        int fi = getFirstIndex(arr, d);
        if (fi == -1) {
            System.out.println("Data not found");
        }
        int li = getLastIndex(arr, d);

        System.out.println(fi);
        System.out.println(getLastIndex(arr, d));
    }

}