import java.util.ArrayList;

public class MinHeap {
    // private ArrayList<Integer> arr;
    private int[] arr;
    private int currentIdx = 0;

    public MinHeap() {
        assign();
    }

    public MinHeap(int[] arr) {
        assign();
        heapConstruct(arr);
    }

    protected void assign() {
        this.arr = new int[10];
    }

    public int size() {
        return this.arr.length;
    }

    public boolean isEmpty() {
        return this.arr.length == 0;
    }

    private void heapConstruct(int[] data) {
        for (int idx = 0; idx < data.length; idx++) {
            this.arr[idx] = data[idx];
            this.currentIdx++;
        }

        for (int i = currentIdx - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void swap(int a, int b) { // o(1)
        int val1 = this.arr[a];
        int val2 = this.arr[b];

        this.arr[a] = val2;
        this.arr[b] = val1;
    }

    private void upHeapify(int ci) { // logn
        int pi = (ci - 1) / 2;

        if (pi >= 0 && this.arr[ci] < this.arr[pi]) {
            swap(pi, ci);
            upHeapify(pi);
        }
    }

    private void downHeapify(int pi) { // logn
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int maxIdx = pi;

        if (lci < currentIdx && this.arr[lci] < this.arr[maxIdx])
            maxIdx = lci;

        if (rci < currentIdx && this.arr[rci] < this.arr[maxIdx])
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    public int top() throws Exception { // o(1)
        if (this.arr.length == 0)
            throw new Exception("NullPointerException");
        return this.arr[0];
    }

    public void add(int data) { // logn
        if (currentIdx == this.arr.length - 1) {
            int[] temp = new int[this.arr.length * 2];
            for (int idx = 0; idx < arr.length; idx++) {
                temp[idx] = this.arr[idx];
            }
            this.arr = temp;
        }

        this.arr[currentIdx] = data;
        upHeapify(currentIdx);
        this.currentIdx++;

    }

    public int remove() throws Exception { // logn
        if (this.arr.length == 0) {
            throw new Exception("NullPointerException");
        }
        int removedEl = this.arr[0];

        swap(0, currentIdx - 1);
        this.arr[currentIdx - 1] = 0;
        this.currentIdx -= 2;
        downHeapify(0);
        return removedEl;
    }

}
