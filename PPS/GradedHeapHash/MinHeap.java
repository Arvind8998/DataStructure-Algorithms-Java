package GradedHeapHash;

class Heap {
    private int[] heapArr;
    private int capacity;
    private int currentHeapSize;

    Heap() {
        this(0);
    }

    Heap(int capacity) {
        this.capacity = capacity;
        heapArr = new int[capacity];
        currentHeapSize = 0;
    }

    public int getMin() {
        return heapArr.length > 0 ? heapArr[0] : -1;
    }

    public void decreaseKey(int i) {
        int parent = (i - 1) / 2;
        while (i != 0 && heapArr[i] < heapArr[parent]) {
            swap(i, parent);
            decreaseKey(parent);
        }
    }

    public void insertKey(int value) {
        if (heapArr.length == currentHeapSize) {
            int[] newArr = new int[currentHeapSize * 2];
            for (int i = 0; i < currentHeapSize; i++) {
                newArr[i] = heapArr[i];
            }
            heapArr = newArr;
        }

        heapArr[currentHeapSize] = value;
        decreaseKey(currentHeapSize);
        currentHeapSize += 1;
    }

    public void removeKey() {
        if (currentHeapSize == 0) {
            return;
        }

        swap(0, currentHeapSize - 1);
        heapArr[currentHeapSize - 1] = 0;
        currentHeapSize -= 2;
        increaseKey(0);
    }

    public void increaseKey(int parent) {
        int smallest = parent;
        int leftChild = (2 * parent) + 1;
        int rightChild = (2 * parent) + 2;

        if (leftChild < currentHeapSize && heapArr[leftChild] < heapArr[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < currentHeapSize && heapArr[rightChild] < heapArr[smallest]) {
            smallest = rightChild;
        }

        if (smallest != parent) {
            swap(parent, smallest);
            increaseKey(smallest);
        }
    }

    public void swap(int i, int parent) {
        int temp = heapArr[parent];
        heapArr[parent] = heapArr[i];
        heapArr[i] = temp;
    }

    public boolean isEmpty() {
        return this.currentHeapSize == 0;
    }

    public void printHeap() {
        for (int i = 0; i <= this.currentHeapSize; i++) {
            if (heapArr[i] == 0) {
                break;
            }
            System.out.println(heapArr[i]);
        }
    }

}

public class MinHeap {
    public static void main(String args[]) {
        int[] arr = { 30, -1, 60, 2 };
        Heap minHeap = new Heap(7);
        minHeap.insertKey(30);
        minHeap.insertKey(-1);
        minHeap.insertKey(60);
        minHeap.insertKey(2);

        minHeap.printHeap();

        // System.out.println(minHeap.getMin());
    }
}