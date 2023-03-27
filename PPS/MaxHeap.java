import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> arr;

    public MaxHeap() {
        assign();
    }

    public MaxHeap(int[] arr) {
        assign();
        heapConstruct(arr);
    }

    protected void assign() {
        this.arr = new ArrayList<>();
    }

    public int size() {
        return this.arr.size();
    }

    public boolean isEmpty() {
        return this.arr.size() == 0;
    }

    private void heapConstruct(int[] data) {
        for (int ele : data)
            this.arr.add(ele);

        for (int i = this.arr.size() - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void swap(int a, int b) { // o(1)
        int val1 = this.arr.get(a);
        int val2 = this.arr.get(b);

        this.arr.set(a, val2);
        this.arr.set(b, val1);
    }

    private void upHeapify(int ci) { // logn
        int pi = (ci - 1) / 2;

        if (pi >= 0 && this.arr.get(ci) > this.arr.get(pi)) {
            swap(pi, ci);
            upHeapify(pi);
        }
    }

    private void downHeapify(int pi) { // logn
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int maxIdx = pi;

        if (lci < this.arr.size() && this.arr.get(lci) > this.arr.get(maxIdx))
            maxIdx = lci;

        if (rci < this.arr.size() && this.arr.get(rci) > this.arr.get(maxIdx))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    public int top() throws Exception { // o(1)
        if (this.arr.size() == 0)
            throw new Exception("NullPointerException");
        return this.arr.get(0);
    }

    public void add(int data) { // logn
        this.arr.add(data);
        upHeapify(this.arr.size() - 1);
    }

    public int remove() throws Exception { // logn
        if (this.arr.size() == 0) {
            throw new Exception("NullPointerException");
        }
        int n = this.arr.size();
        int removedEl = this.arr.get(0);

        swap(0, n - 1);
        this.arr.remove(n - 1);
        downHeapify(0);
        return removedEl;
    }

}
