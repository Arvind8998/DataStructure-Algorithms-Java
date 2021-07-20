package Sorting;

import java.io.*;
import java.util.*;

public class BubbleSort{
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
        int n = arr.length;
        for(int li = n-1; li>0; li--){
            for(int i=1; i<=li; i++){
                    if(arr[i-1] > arr[i]){
                        swap(arr, i,i-1);
                    }
            }
        }
    }
    public static void main(String[] args){
        int a = scn.nextInt();
        int[] arr = new int[a];
        inputArr(arr);
        sortArray(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
    }
}
