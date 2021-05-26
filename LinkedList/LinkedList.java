public  class LinkedList{
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public class Node{
        int data = 0;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    public int size(){
        return this.size;
    }

    private void addFirstNode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    private void addLastNode(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
        }
        else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    private Node getFirstNode(){
       return this.head;
    }

    private Node getLastNode(){
       return this.tail;
    }


    

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-- >0){
            curr = curr.next;
        }
        return curr;
    }

    private Node removeLastNode(){
        Node node = this.tail;
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else{
           Node secondLast = getNodeAt(this.size-2);
           secondLast.next = null;
           this.tail = secondLast;
        }
        
    }

    private void addNodeAt(Node node, int idx){
        if(idx == 0)  addFirstNode(node);
        else if(idx ==1 ) addLastNode(node);
        else{
            Node prevNode = getNodeAt(idx-1);
            Node forwNode = prevNode.next;

            prevNode.next = node;
            node.next = forwNode;
            this.size++;
        }
    }

    public int removeLast(){
        if(this.size == 0)
            return -1;
        return removeLastNode().data;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    public int getFirst(){
        if(this.size == 0)
            return -1;
        return getFirstNode().data;
    }

    public int getLast(){
        if(this.size ==0)
            return -1;
        return getLastNode().data;
    }

    public void addAt(int data, int idx){
        Node node = new Node(data);
        if(this.size == 0){
            return;
        }
        addNodeAt(node,idx);
    }

    function oddEven(){
        Node even = new Node(-1);
        Node ep = even;

        Node odd = Node(-1);
        Node op = odd;

        Node curr = this.head;

        while(curr != null){
            if(curr.data %2 == 0){
                ep.next = curr;
                ep = ep.next;
            }
            else{
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }
        op.next = even.next;
        ep.next = null;

        this.head = odd.next;
        if(even.next != null){
            this.tail = ep;
        }
        else{
            this.tail = op;
        }

    }

    function removeDuplicates(){
        Node dummy = new Node(-1);
        Node dp = dummy;
        Node curr = this.head;
        dp.next = curr;

        while(curr != null){
            if(curr.data != dp.data){
                dp.next = curr;
                dp = dp.next;
            }
            curr = curr.next;
        }
        dp.next = null;
    }
}