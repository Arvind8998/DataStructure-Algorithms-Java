import java.io.*;
import java.util.*;

public class TwodArray{
    
public static Scanner scn = new Scanner(System.in);

public static void input(int[][] arr){
    int n = arr.length;
    int m = arr[0].length;

    for(int i=0;i<n; i++){
        for(int j=0; j<m; j++){
            arr[i][j] = scn.nextInt();
        }
    }
}

public static int minimum(int[][] arr){
    int minVal = (int) 1e9;
    int n = arr.length;
    int m = arr[0].length;

    for(int i = 0; i<n; i++){
        for(int j=0; j<m; j++){
            minVal = Math.min(minVal, arr[i][j]);
        }
    }
    return minVal;
}

public static int maximum(int[][] arr){
    int maxVal = -(int) 1e9;
    int n = arr.length, m = arr[0].length;

    for(int i = 0; i<n; i++){
        for(int j=0; j<m; j++){
            maxVal = Math.max(maxVal, arr[i][j]);
        }
    }
    return maxVal;
}

public static boolean find(int[][] arr, int data){
    boolean res = false;
    int n = arr.length, m = arr[0].length;
    for(int i = 0; i<n; i++){
        for(int j=0; j<m; j++){
            res = arr[i][j] == data;
            if(res){
                return res;
            }
        }
    }
    return false;
}

public static void display(int[][] arr){
    for(int i=0;i<arr.length; i++){
        for(int j=0; j<arr.length; j++){
            System.out.print(arr[i][j] + "");
        }
        System.out.println();
    }
}

public static void main(String[] args) {
    int[][] arr = new int[scn.nextInt()][scn.nextInt()];
    input(arr);
    int data = scn.nextInt();
    // System.out.print(minimum(arr));
    // System.out.print(maximum(arr));
    System.out.print(find(arr, data));
 }

}