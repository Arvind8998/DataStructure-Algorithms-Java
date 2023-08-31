public class stack {
    private int[] arr;
    private int size;
    private int tos;
    private int maxSize;

    public void initialize(int len){
       this.maxSize = len;
       this.arr = new int[len];
       this.tos = -1;
       this.size = 0;
    }

    public stack(){
        initialize(5);
    }

    public stack(int size){
        initialize(size);
    }

    @Override
    public String toString(){
        String str = new String("");
        for(int el: this.arr){
            str += el;
        }
        return str;
    }

    public void stackisEmptyException() throws Exception{
        if(this.size == 0)
        throw new Exception("stackIsEmptyException -1");
    }

    public void stackIsOverFlowException() throws Exception{
        if(this.size == maxSize)
        throw new Exception("stackIsOverflowException -1");
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push_(int data){
        this.arr[++this.tos] = data;
        this.size++;
    }

    public void push(int data) throws Exception{
        stackIsOverFlowException();
        push_(data);
    }

    public int pop_(){
        int num = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.size--;
        return num;
    }

    public int pop() throws Exception{
        stackisEmptyException();
        return pop_();
    }

    public int top() throws Exception{
        stackisEmptyException();
        return this.tos;
    }

}
