package Sorting;

import java.util.*;

public class FourSum {
    public static Scanner scn = new Scanner(System.in);

    public static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static int partition(int[] arr, int si, int ei, int pivot) {
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

    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;
        int pivot = ei;

        int pIdx = partition(arr, si, ei, pivot);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    public static ArrayList<int[]> twoSum(int[] arr, int target, int si, int ei) {
        ArrayList<int[]> ans = new ArrayList<>();
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum == target) 
                ans.add(new int[] { arr[si++], arr[ei--] });
            else if (sum > target)
                ei--;
            else
                si++;
        }
        return ans;
    }                               

    public static ArrayList<int[]> threeSum(int[] arr, int target, int si, int ei ){
        ArrayList<int[]> ans = new ArrayList<>();

        for(int i= si; i<= ei; i++){
            ArrayList<int[]> smallAns = twoSum(arr, target-arr[i], i+1, ei);

            for(int[] a: smallAns){
                ans.add(new int[] {arr[i], a[0], a[1]});
            }
        }

        return ans;
    }

    public static ArrayList<int[]> fourSum(int[] arr, int target, int si, int ei ){
        ArrayList<int[]> ans = new ArrayList<>();

        for(int i= si; i<= ei; i++){
            ArrayList<int[]> smallAns = threeSum(arr, target-arr[i], i+1, ei);

            for(int[] a: smallAns){
                ans.add(new int[] {arr[i], a[0], a[1], a[2]});
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 7, 5, 8, 15, 3, 2, 9, 10, 19 }; 
        int n = arr.length;
        int target = scn.nextInt();
        quickSort(arr, 0, n - 1);

        ArrayList<int []> ans =  fourSum(arr, target, 0, n - 1);

        for(int[] a: ans){
            System.out.println(a[0] + " " + a[1]+ " "+ a[2] + " " + a[3]);
        }
    }
}
