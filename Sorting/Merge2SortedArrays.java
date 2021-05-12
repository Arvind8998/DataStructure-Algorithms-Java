package Sorting;

import java.util.*;
 
 public class Merge2SortedArrays {
 
     public static void mergeWithNoSpace(int[] arr1, int[] arr2) {
         int i=0, j=0,n = arr1.length, m = arr2.length;
        while(i<n && j<m){
            if(arr1[i] <= arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
            }
            else if(arr1[i] > arr2[j]){
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        if(i<n){
            while(i<n){
                System.out.print(arr1[i] + " ");
                i++;
            }
        }
        if(j<m){
            while(j<m){
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
     }  
     
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int[] A = new int[sc.nextInt()];
         int[] B = new int[sc.nextInt()];
         for (int i = 0; i < A.length; i++) {
             A[i] = sc.nextInt();
         }
         for (int i = 0; i < B.length; i++) {
             B[i] = sc.nextInt();
         }
         mergeWithNoSpace(A, B);
     }
     
 }