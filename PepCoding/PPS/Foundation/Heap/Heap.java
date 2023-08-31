package Heap;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> arr;

    private int size() {
        return this.arr.size();
    }

    Heap() {
        initialize();
    }

    protected void initialize() {
        this.arr = new ArrayList<>();
    }

    private boolean isEmpty() {
        return this.arr.size() == 0;
    }

    // private void heapConstruction(){
    // this.arr.add();
    // }

    private void swap(int idx1, int idx2) {
        int val1 = this.arr.get(idx1);
        int val2 = this.arr.get(idx2);

        this.arr.set(idx1, val2);
        this.arr.set(idx2, val1);
    }

    private void upHeapify(int ci) {
        int pi = (ci - 1) / 2;

        if (pi >= 0 && pi < arr.size() && arr.get(ci) > arr.get(pi)) {
            swap(pi, ci);
            upHeapify(pi);
        }
    }

    private void downHeapify(int pi){
        int lci = 2*pi +1;
        int rci = 2*pi+2;
        

    }
}
