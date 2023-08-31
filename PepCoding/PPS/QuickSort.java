
public class QuickSort {

    public static void swap(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static int partitionIdx(int[] arr, int si, int ei, int pivot) {
        swap(arr, pivot, ei);

        int left = si - 1, right = si;
        while (right <= ei) {
            if (arr[right] <= arr[ei]) {
                swap(arr, ++left, right);
            }
            right++;
        }
        return left;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;

        int pivot = ei;
        int p = partitionIdx(arr, si, ei, pivot);

        quickSort(arr, si, p - 1);
        quickSort(arr, p + 1, ei);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 1 };
        quickSort(arr, 0, arr.length - 1);

        for(int val: arr){
            System.out.println(val);
        }
    }
}
