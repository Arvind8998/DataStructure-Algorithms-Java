//Complexity -> o(n*n)
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

public static void swapArr(int[][] arr, int i1, int j1, int i2, int j2){
    int temp = arr[i1][j1];
    arr[i1][j1] = arr[i2][j2];
    arr[i2][j2] = temp;
}

public static int[][] NinetyDegRotate(int[][] arr){
    
    int n= arr.length;
    int m = arr[0].length;
    //Matrix Transpose
    for(int i=0; i<n; i++){
        for(int j =i; j<m; j++){
            swapArr(arr, i, j ,j,i);
        }
    }
    
    int si=0; int ei =m-1;
    while(si < ei){
        for(int i=0; i<n; i++){
          swapArr(arr, i, si, i, ei);
        }
        si++;
        ei--;
    }
    
    return arr;
}

//Reverse Column
public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        inputArr(arr);
        int[][] outArr = NinetyDegRotate(arr);
        display(arr);
    }

    

}