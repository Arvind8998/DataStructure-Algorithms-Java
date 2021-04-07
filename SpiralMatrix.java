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

public static void SpiralMatrix(int[][] arr){
    int n = arr.length; int m = arr[0].length;
    int cmin =0, rmin=0, rmax=n-1, cmax =m-1;
    int tnel = n*m;
    
    while(tnel >0){
        for(int r= rmin; r<= rmax && tnel >0; r++){
        System.out.println(arr[r][cmin]);
        tnel--;
    }
    cmin++;
    
    for(int c= cmin; c<= cmax && tnel >0; c++){
        System.out.println(arr[rmax][c]);
        tnel--;
    }
    rmax--;
    
    for(int r= rmax; r>= rmin && tnel >0; r--){
        System.out.println(arr[r][cmax]);
        tnel--;
    }
    cmax--;
    
     for(int c= cmax; c>= cmin && tnel >0; c--){
        System.out.println(arr[rmin][c]);
        tnel--;
    }
    rmin++;
    }
    
}
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        inputArr(arr);
        SpiralMatrix(arr);
    }

}