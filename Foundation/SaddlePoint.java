import java.io.*;
import java.util.*;

public class Main {

public static Scanner scn = new Scanner(System.in);

public static void inputArr(int[][] arr){
    int n = arr.length; int m = arr[0].length;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            arr[i][j] = scn.nextInt();
        }
    }
}

public static int colMax(int[][] arr, int c){
    int n = arr.length;
    int maxVal = -(int)1e9;
    int r = -1;
    for(int i=0; i<n; i++){
        if(arr[i][c] > maxVal){
            maxVal = Math.max(maxVal, arr[i][c]);
        r = i;
        }
        
    }
    return r;
}


public static void saddlePoint(int[][] arr){
    int n = arr.length; 
    int m = arr[0].length;
    boolean flag = false;
    
    for(int i=0; i<n;i++){
        int minEl = (int) 1e9;
        int c=-1;
        for(int j=0; j<m; j++){
            if(arr[i][j] < minEl){
            minEl = Math.min(minEl, arr[i][j]);
            c = j;
            }
        }
        int r = colMax(arr, c);
        if(r == i){
            System.out.print(arr[r][c]);
            flag = true;
        }
        
    }
    
    if(!flag){
        System.out.println("Invalid input");
    }
}

    public static void main(String[] args) throws Exception {
        int n =scn.nextInt();
        int[][] arr = new int[n][n];
        inputArr(arr);
        saddlePoint(arr);
    }

}