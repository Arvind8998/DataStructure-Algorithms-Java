//Heap Sort is best to find kth largest
package Sorting;

import java.util.*;

public class quickSelect {

    public static Scanner scn = new Scanner(System.in);

    public static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static int partition(int[] arr, int si, int ei, int pivot, int idx) {
        int p = si-1, itr = si;

        swap(arr, pivot, ei);

        while(itr <= ei){
            if(arr[itr] <= arr[ei]){
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }

    public static void quickSelection(int[] arr, int si, int ei, int idx) {
        if (si > ei)
            return;

        int pivot = ei;
        int pIdx = partition(arr, si, ei, pivot, idx);

        if (idx == pIdx)
            return;
        else if (idx > pIdx) {
            quickSelection(arr, pIdx + 1, ei, idx);
        } else {
            quickSelection(arr, si, pIdx - 1, idx);
        }
    }

    public static int quickSelection(int[] arr, int k) {
        int n = arr.length, idx = n - k;
        quickSelection(arr, 0, n - 1, idx);
        return arr[idx];
    }

    public static void main(String[] args) {
        int[] arr = { -12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3 };
        int k = 4;

        quickSelection(arr, k);
        System.out.println(quickSelection(arr,k));
    }
}

