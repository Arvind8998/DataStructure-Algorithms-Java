import java.util.*;

public class BrokenEconomy{

public static Scanner scn = new Scanner(System.in);

public static void inputArr(int[] arr){
    int n = arr.length;
    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }
}

public static void printBrokenEconomyFloorCeil(int[] arr, int num){
    int n = arr.length;
    int low= 0;
    int high = n-1;
    int floor = 0;
    int ceil = 1;
    
    while(low <= high){
        int mid = (low+high)/2;
        if(num > arr[mid]){
            low = mid+1;
            floor = arr[mid];
        }
        else if(num < arr[mid]){
            high = mid-1;
            ceil = arr[mid];
        }
        else{
            floor = arr[mid];
            ceil = arr[mid];
        }
    }
    System.out.println(ceil);
    System.out.println(floor);
    
}

public static void main(String[] args) throws Exception {
    int n = scn.nextInt();
    int[] arr = new int[n];
    inputArr(arr);
    int num = scn.nextInt();
    printBrokenEconomyFloorCeil(arr,num);
 }
}