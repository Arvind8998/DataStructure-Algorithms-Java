package Sorting;

import java.util.*;

public class GreaterthanZero {

    public static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static int partition(int[] arr, int si, int ei, int pivot, int idx) {
        int p = si - 1, itr = si;

        swap(arr, pivot, ei);

        while (itr <= ei) {
            if (arr[itr] <= arr[ei]) {
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }

    public static void quickSort(int[] arr, int si, int ei, int idx) {
        if (si > ei)
            return;

        int pivot = ei;
        int pIdx = partition(arr, si, ei, pivot, idx);
        quickSort(arr, si, pIdx - 1, idx);
        quickSort(arr, pIdx + 1, ei, idx);
    }

    public static void quickSort(int[] arr, int k) {
        int n = arr.length, idx = n - k;
        quickSort(arr, 0, n - 1, idx);
    }

    public static int[] removeDuplicates(int [] arr){
        int n = arr.length;
        int[] ans = new int[n];
        int idx =0;
        int prev = '$';
        for(int i=0; i<n; i++){
            if(prev != arr[i]){
                ans[idx++] = arr[i];
                prev = arr[i]; 
            }
        }
        return ans;
    }

    public static int getEleFreaterThanZero(int [] arr){
        int n = arr.length;
        int counter = -1;
        for(int i=0; i<n; i++){
            if(arr[i] <0) continue;
            else if(arr[i] >= 0){
                counter++; 
            }
            else if(counter != arr[i]){
                break;
            }
        }
        return counter;
    }
    

    public static void main(String[] args) {
        int[] arr = { -12, 2, 1, 2, 4, 4, 4, 4, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3};
        int k = 4;
        quickSort(arr, k);
        int[] arrData = removeDuplicates( arr);
        System.out.println(getEleFreaterThanZero(arrData));
        
    }
}
