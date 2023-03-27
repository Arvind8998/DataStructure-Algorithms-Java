public class Client {
    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 5, -2, -4, 50, 70, -9, -90, 30, 100, 89 };
        // MaxHeap hp = new MaxHeap(arr);
        MinHeap hp = new MinHeap(arr);


        while (hp.size() != 0) {
            System.out.println(hp.remove() + " ");
        }
    }
}
