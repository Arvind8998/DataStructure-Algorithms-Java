package Sorting;
//Nlogn -> T(N) ->Avergage/Best , Worst-> o(n2)
public class QuickSort {

    public static void swap(int[] arr, int si, int ei){
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static int partitionArray(int[] arr, int si, int ei, int pIdx){
        int p = si-1, itr = si;

        swap(arr, si, pIdx);

        while(itr <= ei){
            if(arr[itr] <= arr[ei]){
                swap(arr, itr, ++p);
            }
            itr++;
        }
        return p;
    }

    public static void quickSort(int[] arr, int si, int ei){
        if(si >= ei) 
        return;

        int pIdx = ei;
        int p = partitionArray(arr, si, ei, pIdx);
        quickSort(arr, si, p-1);
        quickSort(arr, p+1, ei);

    }
    public static void main(String[] args){
        int[] arr = {-12, 2, 7, 4, 34, 23, 0, 1, -1, -50, 16, 23, 7, 4, 2, 3};
        int n = arr.length;
        quickSort(arr, 0, n-1);

        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
