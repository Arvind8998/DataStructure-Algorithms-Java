import java.util.*;

public class Main {
    
    public static Scanner scn = new Scanner(System.in);

    public static void inputArr(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
                arr[i] = scn.nextInt();
            }
        }

    public static void printEleInRange(int[] arr, int si, int ei){
        while(si <= ei){
            System.out.print(arr[si]+"\t");
            si++;
        }
        
    }

    public static void printAllSubArrays(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                printEleInRange(arr, i ,j);
                System.out.println();
            }
            
        }
    }

    public static void main(String[] args){
        int n = scn.nextInt();
        int[] arr = new int[n];
        inputArr(arr);
        printAllSubArrays(arr);
    }


}
