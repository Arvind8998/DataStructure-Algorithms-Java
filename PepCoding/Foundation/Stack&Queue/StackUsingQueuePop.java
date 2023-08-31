class MyStack {

    LinkedList<Integer> queue = new LinkedList<Integer> ();
    LinkedList<Integer> temp = new LinkedList<Integer> ();
    
    int peekEle = 0;
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    public void transfer(LinkedList l1, LinkedList l2){
        while(l1.size() != 0){
            l2.addLast(l1.removeFirst());
        }
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        transfer(queue, temp);
        queue.addLast(x);
        transfer(temp, queue);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.removeFirst();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.getFirst();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0 ;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */