
public class QuickSort {

    public void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    // public int partition(int[] arr, int left, int right) {

    // }

    public void quickSort(int[] arr, int left, int right){
        int pivot = right;
        quickSort(arr, left, pivot);
        // quickSort(pivot, , right);

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
