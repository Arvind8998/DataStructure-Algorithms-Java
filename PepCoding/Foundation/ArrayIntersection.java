import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    
    public static void inputArr(int[] arr){
    int n = arr.length;
    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    }
    
    public static void printIntersection(int[] arr, int[] arr1){
        int n = arr.length, m = arr1.length;
         ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j =i; j<m; j++){
                if(arr[i] == arr1[j]){
                ans.add(arr1[j]);
                break;
            }
            }        
        }
System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        inputArr(arr);
        Arrays.sort(arr);
        int m = scn.nextInt();
        int[] arr1 = new int[m];
        inputArr(arr1);
        Arrays.sort(arr1);
        printIntersection(arr,arr1);
        
    }
}