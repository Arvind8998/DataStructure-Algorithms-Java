package Sorting;

import java.io.*;
import java.util.*;

public class ZeroOneTwo{
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
        int itr = 0, pt = -1, n = arr.length, pt2 = n-1;

        while(itr <= pt2){
            if(arr[itr] ==0){
                swap(arr, ++pt, itr++);
            }
            else if(arr[itr] ==1){
                ++itr;
            }
            else if(arr[itr] ==2){
                swap(arr, pt2--, itr);
            }
            
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


/*
pt=-1
itr=0
pt2=5


0,1,0,2,1,2,1
0->
pt=0
itr=1
pt2=5

0,1,0,2,1,2,1
1-> 
pt-0
itr=2
pt2=5

0,0,1,2,1,2,1

0->
pt=1
itr=3
pt2=5

0,0,1,2,1,2,1
2->
pt-1
itr=2
pt2=5


if(0){
swap(arr, ++p, itr)
}

if(2){
    arr, pt2,itr
    --pt2
}
itr++



*/