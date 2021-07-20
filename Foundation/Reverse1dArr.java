import java.io.*;
import java.util.*;

public class Reverse1dArr{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }
  
  public static void swap(int[] arr, int i, int j){
      int temp = arr[i];
      arr[i]= arr[j];
      arr[j] = temp;
  }

  public static void reverse(int[] arr){
      int n = arr.length;
      int i = 0;
      int j = n-1;
    while(i <j){
        swap(arr, i,j);
        i++;
        j--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
 }

}