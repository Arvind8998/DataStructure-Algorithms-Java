package Sorting;

import java.io.*;
import java.util.*;

public class ZeroOneSortArray{
    public static Scanner scn = new Scanner(System.in);

    public static void inputArr(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            arr[i]  =scn.nextInt();
        }
    }

    public static void swap(int[] arr, int si, int di){
        int temp = arr[si];
        arr[si] = arr[di];
        arr[di] = temp;
    }

    public static void sortArray(int[] arr){
        int itr = 0, pt = -1, n = arr.length;

        while(itr < n){
            if(arr[itr] ==0){
                swap(arr, ++pt, itr);
            }
            itr++;
        }
    }
    public static void main(String[] args){
        int a = scn.nextInt();
        int[] arr = new int[a];
        inputArr(arr);
        sortArray(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}