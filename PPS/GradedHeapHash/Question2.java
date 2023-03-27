package GradedHeapHash;

import java.util.Scanner;

public class Question2 {

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int noOfEle = sc.nextInt();
        int arrSize = (int) (Math.pow(2, (Math.log(noOfEle) / Math.log(2)) + 2) - 1);
        int[] arr = new int[arrSize];

        for (int i = 0; i < noOfEle; i++) {
            arr[i] = sc.nextInt();
        }

        Heap heap = new Heap(arr, noOfEle);

        System.out.print("HEAP BEFORE REMOVALS: ");
        heap.printHeap();
        System.out.println();

        int[] sortedArr = new int[arrSize];
        int index = 0;
        while (!heap.isHeapEmpty()) {
            sortedArr[index] = heap.removeMin();
            heap.printHeap();
            if (!heap.isHeapEmpty()) {
                System.out.println();
            }
            index++;
        }
        System.out.print("SORTED VALUES: ");
        print(sortedArr);

        sc.close();
    }
}

class Heap {

    int[] heapArr;
    int currSizeOfHeap;

    Heap(int[] arr, int noOfEle) {
        heapArr = arr;
        currSizeOfHeap = noOfEle - 1;
    }

    public void upHeap(int index) {
        int parentIndex = (int) ((index - 1) / 2);
        if (heapArr[index] < heapArr[parentIndex]) {
            int temp = heapArr[index];
            heapArr[index] = heapArr[parentIndex];
            heapArr[parentIndex] = temp;
            upHeap(parentIndex);
        }
        return;
    }

    public void add(int val) {
        currSizeOfHeap++;
        heapArr[currSizeOfHeap] = val;
        upHeap(currSizeOfHeap);
    }

    public void downHeap(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (currSizeOfHeap < leftChildIndex) {
            return;
        } else if (currSizeOfHeap == leftChildIndex) {
            if (heapArr[leftChildIndex] < heapArr[index]) {
                int temp = heapArr[leftChildIndex];
                heapArr[leftChildIndex] = heapArr[index];
                heapArr[index] = temp;
                downHeap(leftChildIndex);
            }
        } else {
            int swapIndex;
            if (heapArr[leftChildIndex] < heapArr[rightChildIndex]) {
                swapIndex = leftChildIndex;
            } else {
                swapIndex = rightChildIndex;
            }

            if (heapArr[swapIndex] < heapArr[index]) {
                int temp = heapArr[swapIndex];
                heapArr[swapIndex] = heapArr[index];
                heapArr[index] = temp;
                downHeap(swapIndex);
            }
        }

    }

    public int removeMin() {
        int minEle = heapArr[0];
        heapArr[0] = heapArr[currSizeOfHeap];
        heapArr[currSizeOfHeap] = 0;
        currSizeOfHeap--;
        downHeap(0);
        return minEle;
    }

    public void printHeap() {
        for (int i = 0; i <= currSizeOfHeap; i++) {
            if (heapArr[i] == 0) {
                break;
            }
            System.out.println(heapArr[i]);
        }
    }

    public boolean isHeapEmpty() {
        return currSizeOfHeap == -1;
    }
}
