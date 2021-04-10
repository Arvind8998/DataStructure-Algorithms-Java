import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
  
  public static void swap(int[] arr, int i, int j){
      int temp  = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
  
  public static void reverseArr(int[] arr, int i, int j){
      while(i < j){
          swap(arr, i, j);
          i++;
          j--;
      }
  }

  public static void rotate(int[] a, int r){
      int n = a.length;
      
      r %= n;
      
      if(r <0){
          r+=n;
      }
      
    reverseArr(a, 0, n-1);
    reverseArr(a, 0, r-1);
    reverseArr(a, r, n-1);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}