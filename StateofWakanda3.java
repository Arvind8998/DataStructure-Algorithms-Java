import java.io.*;
import java.util.*;
// 4
// 11 12 13 14
// 21 22 23 24
// 31 32 33 34
// 41 42 43 44
public class StateofWakanda3{

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
      
    public static void Wakanda2(int[][] arr){
        System.out.println();
        int n = arr.length, m = arr[0].length;
        for (int gap = 0; gap <= n-1; gap++) {
            for (int i = gap, j = 0; i < n && j < m; i++, j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
        
public static void main(String[] args) throws Exception {
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    input(arr);
    Wakanda2(arr);
    
 }

}