package Sorting;
////Nlogn -> Avergage/Best, Worst
//Heap Sort is best to find kth largest
package Sorting;

import java.util.*;

public class mergeSort {

    public static Scanner scn = new Scanner(System.in);

    public static int mergeTwoSortedArrays(int[] arr, int k) {
        int n = arr.length, idx = n - k;
        quickSelection(arr, 0, n - 1, idx);
        return arr[idx];
    }

    public static int[] mergeSorting(int[] arr, int si, int ei) {
        if (si == ei){
            return new int[] {arr[si]};
        }

        int mid = (si + ei) /2;
        int[] left = mergeSorting(arr, si, mid);
        int[] right = mergeSorting(arr, si, mid);

        return mergeTwoSortedArrays(left, right);
    }

    public static void main(String[] args) {
        int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        int k = 4;

        quickSelection(arr, k);
        System.out.println(quickSelection(arr,k));
    }
}


