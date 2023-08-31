public class Stack {
    private int tos;
    private int noOfElements;
    private int size;
    private int[] arr;
    private int MaxCapacity;

    Stack(int size) {
        initialize(size);
    }

    Stack() {
        this(1);
    }

    protected void initialize(int size) {
        this.MaxCapacity = size;
        this.arr = new int[MaxCapacity];
        this.tos = -1;
        this.noOfElements = 0;
    }

    public void overFlowException() throws Exception {
        if (this.noOfElements == this.MaxCapacity) {
            throw new Exception("Stack IS OverFlowing");
        }
    }

    public void underFlowException() throws Exception {
        if (this.noOfElements == 0) {
            throw new Exception("Stack IS Underflowing");
        }
    }

    public void push(int data) throws Exception {
        // overFlowException();
        if (this.tos == this.arr.length - 1) {
            int[] temp = new int[2 * this.arr.length];

            int idx = 0;

            while (idx < this.arr.length) {
                temp[idx] = this.arr[idx];
                idx++;
            }
            this.arr = temp;
        }
        this.arr[++this.tos] = data;
        this.noOfElements++;

    }

    public int pop() throws Exception {
        overFlowException();
        int removedEl = this.arr[this.tos--];
        this.noOfElements--;
        return removedEl;
    }

    public int peek() throws Exception {
        underFlowException();
        return this.arr[this.tos];
    }

    public static void main(String[] args) throws Exception {
        Stack st = new Stack(1);

        st.push(5);
        st.push(15);
        st.push(52);
        st.push(55);
        st.push(51);
        st.push(80);
        System.out.print(st.peek());
    }

}
