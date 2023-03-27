package GradedHeapHash;

import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfEle = sc.nextInt();
        int arrSize = (int) (Math.pow(2, (Math.log(noOfEle) / Math.log(2)) + 2) - 1);
        int[] arr = new int[arrSize];

        for (int i = 0; i < noOfEle; i++) {
            arr[i] = sc.nextInt();
        }

        Heap1 heap = new Heap1(arr, noOfEle);

        int valueToAdd = sc.nextInt();
        System.out.print("HEAP BEFORE ADD: ");
        heap.printHeap();
        heap.add(valueToAdd);
        System.out.print("HEAP AFTER ADD: ");
        heap.printHeap();

        System.out.println("Min: " + heap.removeMin());
        System.out.print("HEAP AFTER REMOVE: ");
        heap.printHeap();

        sc.close();
    }
}

class Heap1 {

    int[] heapArr;
    int currSizeOfHeap;

    Heap1(int[] arr, int noOfEle) {
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
