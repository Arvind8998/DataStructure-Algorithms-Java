import java.io.*;
import java.util.*;

public class StateOfWakanda2{

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
        int n = arr.length; int m = arr.length;
        for(int gap =0; gap<n; gap++){
            for(int i=0, j=gap; i<n && j<m; i++,j++){
                System.out.println(arr[i][j]);
            }
        }
    }
        
public static void main(String[] args) throws Exception {
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    input(arr);
    Wakanda2(arr);
    
 }

}