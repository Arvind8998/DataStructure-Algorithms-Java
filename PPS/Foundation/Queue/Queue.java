
public class Queue {
    private int[] data;
    private int front;
    int size;

    void initialize(int size) {
        this.data = new int[size];
    }

    void display() {
        for (int i = 0; i < this.size; i++) {
            int idx = (front + i) % data.length;
            System.out.print(this.data[idx]);
        }
    }

    public int size() {
        return this.size;
    }

    public void add(int val) {
        if (this.size == this.data.length) {
            System.out.println("Queue overflow");
        } else {
            int rear = (this.front + this.size) % this.data.length;
            this.data[rear] = val;
            this.size++;
        }
    }

    public int remove() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
        } else {
            int val = this.data[front];
            this.front = (this.front + 1) % this.data.length;
            this.size--;
            return val;
        }
    }

    public int peek() {
        if (this.size == 0) {
            System.out.println("Queue underflow");
            return -1;
        } else {
            return this.data[front];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.initialize(5);
        queue.add(0);
        queue.add(3);
        queue.add(5);
        queue.add(6);
        queue.display();
    }
}
