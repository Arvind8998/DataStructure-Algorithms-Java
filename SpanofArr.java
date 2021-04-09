import java.io.*;
import java.util.*;

public class Main{
    
public static Scanner scn = new Scanner(System.in);

public static void inputArr(int[] arr){
    int n = arr.length;
    for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
    }

public static int spanofArr(int[] arr){
    int max = -(int) 1e9;
    int min = (int) 1e9;
    for(int i=0; i<arr.length; i++){
        if(arr[i] > max)
               max = Math.max(arr[i],max);
        else
                min = Math.min(arr[i],min);
            
    }
    return max-min;
}

public static void main(String[] args) throws Exception {
    int n = scn.nextInt();

    int[] arr = new int[n];
    inputArr(arr);
    System.out.print(spanofArr(arr));
 }

}