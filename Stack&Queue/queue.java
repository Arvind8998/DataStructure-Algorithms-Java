public class queue {
    private int front;
    private int back;
    private int maxSize;
    private int[] arr;
    private int size;

    public void initialize(int len) {
        this.front = 0;
        this.back = 0;
        this.maxSize = len;
        this.size = 0;
        this.arr = new int[len];
    }

    queue() {
        initialize(8);
    }

    queue(int len) {
        initialize(len);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < this.maxSize; i++) {
            int idx = (i + this.front) % this.maxSize;
            if(idx == this.back) break;
            sb.append(this.arr[idx]);
            if (idx != this.back - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public void queIsEmptyException() throws Exception {
        if (this.size == 0)
            throw new Exception("queIsEmptyException -1");
    }

    public void queueIsOverFlowException() throws Exception {
        if (this.size == this.maxSize)
            throw new Exception("queueIsOverFlowException -1");
    }

    public void add_(int data) {
        this.arr[this.back] = data;
        this.back = (this.back + 1) % (this.maxSize);
        this.size++;
    }

    public void add(int data) throws Exception {
        queueIsOverFlowException();
        add_(data);
    }

    public int remove() throws Exception {
        queIsEmptyException();
        int data = this.arr[this.front];
        this.arr[this.front] = 0;
        this.front = (this.front + 1) % (this.maxSize);
        this.size--;
        return data;
    }
    

    public int peek() {
        return this.arr[this.front];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
