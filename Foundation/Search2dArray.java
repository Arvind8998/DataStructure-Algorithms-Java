import java.io.*;
import java.util.*;

public class search2dArr {
    
    public static Scanner scn = new Scanner(System.in);
    
    public static void inputArr(int[][] arr){
        int n= arr.length, m = arr[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
    }
    
    public static void searchIn2dArr(int[][] arr, int x){
        int n = arr.length, m = arr[0].length;
        int i =0, j = arr[0].length-1;
        while( i<n && j >=0){
            if(arr[i][j] == x){
                System.out.println(i);
                System.out.println(j);
                return;
            }
            else if(x > arr[i][j]){
                i++;
            }
            else{
                j--;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        inputArr(arr);
        int x = scn.nextInt();
        searchIn2dArr(arr,x);
    }
}