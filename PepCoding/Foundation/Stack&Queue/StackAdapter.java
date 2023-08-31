public class StackAdapter {
   private Node head;
   private Node tail;
   private int size;

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        sb.append("[");
        while(node != null){
            sb.append(node.data);
            if(node.next != null) sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void addFirst(int data){
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    private int getFirst(){
        if(this.size == 0) return -1;
        return this.head.data;
    }

    private int removeFirst(){
        if(this.size == 0 ) return -1;
        Node node = this.head;
        this.head = node.next;
        node.next = null;
        this.size--;
        return node.data;
    }

    public void push(int data){
        addFirst(data);
    }

    public int pop(){
       return removeFirst();
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int peek(){
        return this.head.data;
    }

    public static void main(String[] args){
        StackAdapter stack = new StackAdapter();
        stack.push(100);
        stack.push(90);
        stack.push(80);
        stack.push(70);
        stack.push(60);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        System.out.println(stack.peek());
    }

}
