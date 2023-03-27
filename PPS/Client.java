public class Client {
    public static void main(String[] args) throws Exception {

        // minHeap.insertKey(2);
        // minHeap.insertKey(4);
        // minHeap.insertKey(5);
        // minHeap.insertKey(6);
        // minHeap.insertKey(7);
        // minHeap.insertKey(1);
        // minHeap.insertKey(8);
        // minHeap.insertKey(3);
        int[] arr = { 30, -1, 60, 2 };
        // int[] arr = { 10, 5, -2, -4, 50, 70, -9, -90, 30, 100, 89 };
        MaxHeap hp = new MaxHeap(arr);
        // MinHeap hp = new MinHeap(arr);

        // System.out.print("HEAP BEFORE ADD: ");
        // hp.printHeap();

        // hp.add(9);

        // System.out.print("HEAP AFTER ADD: ");
        // hp.printHeap();

        while (hp.size() != 0) {
            System.out.println(hp.remove() + " ");
            // System.out.println(hp.top() + " ");
        }
    }
}
