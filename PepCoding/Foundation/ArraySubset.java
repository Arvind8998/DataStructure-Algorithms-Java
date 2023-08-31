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

public static void printSubset(int[] arr){
    int n = arr.length;
    int limit = (int)Math.pow(2,arr.length);
    for(int i=0; i<limit; i++){
        int temp = i;
        String set = "";
        for(int j =n-1; j >=0; j--){
            int rem = temp%2;
            temp /= 2;
            
            if(rem == 0){
               set = "-\t" + set; 
            }
            else{
                set = arr[j] + "\t" + set;
            }
        }
        System.out.println(set);
    }
}

public static void main(String[] args) throws Exception {
    int n = scn.nextInt();
    int[] arr = new int[n];
    inputArr(arr);
    printSubset(arr);
    
 }

}