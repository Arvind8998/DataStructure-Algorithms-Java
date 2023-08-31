import java.util.*;
 
 public class Main {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input a length and a 2D array of update operations.
     // It should return the modified array.
     public static int[] Range(int length, int[][] updates) {
         int[] res = new int[length];
         int preSum = 0;

         for(int i = 0; i<updates.length; i++){
             int si = updates[i][0];
             int ei = updates[i][1];
             int inr = updates[i][2];

             res[si] += inr;

             if(ei+1 < res.length){
                res[ei + 1] -= inr;
             }
         }

         for(int idx=0; idx<res.length; idx++){
            preSum += res[idx];
            res[idx] = preSum;
         }
         return res;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int length = sc.nextInt();
 
         int K = sc.nextInt();
 
         int[][] updates = new int[K][3];
 
         for (int i = 0; i < updates.length; i++) {
             for (int j = 0; j < updates[0].length; j++) {
                 updates[i][j] = sc.nextInt();
             }
         }
 
         int[] result = Range(length, updates);
         display(result);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 
 }