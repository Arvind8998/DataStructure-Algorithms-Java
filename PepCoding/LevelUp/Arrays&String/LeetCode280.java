import java.util.*;

public class Main {

    public static void swap(int si, int ei, int[] arr) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static void wiggleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i + 1] <= arr[i]) {
                    swap(i, i + 1, arr);
                }
            } else {
                if (arr[i + 1] >= arr[i]) {
                    swap(i + 1, i, arr);
                }
            }
        }
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        wiggleSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
