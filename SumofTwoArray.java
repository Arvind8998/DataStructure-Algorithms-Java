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
    
     public static void SumofTwoArray(int[] arr1, int[] arr2){
        int n =arr1.length, m = arr2.length;
         int i = n-1, j=m-1;
         int p = Math.max(n,m)+1;
         int[] ans = new int[p];
         int k= p-1, carry = 0;
         
    while(k >0){
        int sum = carry + ((i >=0 ? arr1[i]: 0) + (j >=0 ? arr2[j]: 0));
        ans[k] = sum %10;
        carry = sum/10;
        i--;
        j--;
        k--;
    }
    
    for(int idx=0; idx<p; idx++ ){
        if(idx==0 && ans[idx] == 0) continue;
        System.out.println(ans[idx]);
    }
    }
    

public static void main(String[] args) throws Exception {
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    inputArr(arr1);
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    inputArr(arr2);
    SumofTwoArray(arr1, arr2);
    
 }

}