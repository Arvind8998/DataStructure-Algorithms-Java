package GradedHeapHash;

public class BuildHeap {

    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }

    static void buildHeap(int arr[], int N) {
        int startIdx = (N / 2) - 1;

        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }

    static void printHeap(int arr[], int N) {
        System.out.println(
                "Array representation of Heap is:");

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 60, 30, -1, 2 };
        int N = arr.length;

        buildHeap(arr, N);
        printHeap(arr, N);
    }
}
