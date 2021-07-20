import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    
    public static void inputArr(int[][] arr){
    int n = arr.length;
    int m = arr[0].length;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
        arr[i][j] = scn.nextInt();
        }    
    }
}
    
    public static void printMatrixTrace(int[][] arr, int[][] arr1){

    int n = arr.length, m =arr[0].length, p = arr1.length, q = arr1[0].length, sum=0;
    for(int i=0, j=0, k=0, l =0; i<n && j<m && k<p && l < q; i++,j++,k++,l++){
        sum += arr[i][j] + arr1[k][l];
    }
System.out.println(sum);
}
    public static void main(String[] args) {
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        inputArr(arr);
        int[][] arr1 = new int[r][c];
        inputArr(arr1);
        printMatrixTrace(arr,arr1);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}