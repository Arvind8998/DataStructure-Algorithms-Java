import java.io.*;
import java.util.*;

public class span{

public static Scanner scn = new Scanner(System.in);

public static void main(String[] args) throws Exception {
    int n = scn.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; i++){
        arr[i]= scn.nextInt();
    }

    int max = arr[0]; int min= arr[0];

    for(int idx =0; idx<n; idx++){
        if(arr[idx] > max){
            max = arr[idx];
        }
        if(arr[idx] < min){
            min = arr[idx];
        }
    }

    System.out.print(max-min);
 }

}