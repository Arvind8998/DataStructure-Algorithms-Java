public class QueueAdapter {
    private Node head;
    private Node tail;
    private int size;
 
     public  class Node{
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
 
     public void addLast(int data){
       Node node = new Node(data);
       if(this.size == 0){
           this.head = this.tail = node;
       }
       else{
           this.tail.next = node;
           this.tail = node;
       }
       this.size++;
     }
 
     private Node removeFirst_(){
        Node node = this.head;
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else{
            this.head = node.next;
        }
        node.next = null;
        this.size--;
        return node;
     }
 
     private int removeFirst(){
         if(this.size == 0 ) return -1;
        return removeFirst_().data;
     }
 
     public void push(int data){
         addLast(data);
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
         return this.tail.data;
     }
 
     public static void main(String[] args){
        QueueAdapter queue = new QueueAdapter();
         queue.push(100);
         queue.push(90);
         queue.push(80);
         queue.push(70);
         queue.push(60);
         queue.pop();
         queue.pop();
         queue.pop();
         queue.push(50);
         queue.push(40);
         queue.push(30);
         queue.push(20);
         System.out.println(queue);
     }
 }
 