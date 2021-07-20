import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> arr;
    private int noOfEle = 0;
    private boolean isMaxHeap = true;

    private void initialize(boolean isMaxHeap) {
        this.arr = new ArrayList<>();
        this.noOfEle = 0;
        this.isMaxHeap = isMaxHeap;
    }

    public heap(boolean isMaxHeap) {
        initialize(isMaxHeap);
    }

    public heap() {
        this(true);
    }

    public heap(int[] data, boolean isMaxHeap) {
        this(isMaxHeap);

        for (int el : data)
            this.arr.add(el);

        this.noOfEle = this.arr.size();

        for (int i = noOfEle - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void underFlowPointerException() throws Exception {
        if (this.noOfEle == 0)
            throw new Exception("HeapUnderFlowException");
    }

    public int size() {
        return this.noOfEle;
    }

    public boolean isEmpty() {
        return this.noOfEle;
    }

    public int compareTo(int t, int o) {
        if (isMaxHeap) {
            return this.arr.get(t) - this.arr.get(o);
        } else {
            return this.arr.get(0) - this.arr.get(t);
        }
    }

    public void swap(int i, int j) {
        int e1 = this.arr.get(i);
        int e2 = this.arr.get(j);

        this.arr.set(i, e2);
        this.arr.set(j, e1);
    }

    private void downHeapify(int pi) {
        int maxIdx = pi, lci = 2 * p1 + 1, rci = 2 * pi + 2;
        if (lci < this.noOfEle && compareTo(lci, maxIdx) > 0)
            maxIdx = lci;
        if (rci < this.noOfEle && compareTo(rci, maxIdx) > 0)
            maxIdx = lci;
        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downHeapify(maxIdx);
        }
    }

    private void upHeapify(int ci){
        in pi  = (ci-1)/2;
        if(pi >=0 && compareTo(ci, pi) >0){
            swap(ci, pi);
            upHeapify(pi);
        }
    }

    public int peek() throws Exception {
        underFlowPointerException();
        return this.arr.get(0);
    }

    public int remove() throws Exception {
        underFlowPointerException();
        int rEle = this.arr.get(0);
        swap(0, this.noOfEle - 1);
        this.arr.remove(this.noOfEle - 1);

        this.noOfEle--;
        downHeapify(0);

        return rEle;
    }

    public void add(int data) {
        this.arr.add(data);
        this.noOfEle++;
        upheapify(this.noOfEle - 1);
    }

}
