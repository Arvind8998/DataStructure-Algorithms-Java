class MyStack {

    LinkedList<Integer> queue = new LinkedList<Integer> ();
    LinkedList<Integer> temp = new LinkedList<Integer> ();
    
    int peekEle = 0;
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        peekEle = x;
        queue.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue.size() >1) temp.addLast(queue.removeFirst());
        int rEl = queue.removeFirst();
        
        while(temp.size() !=0){
            push(temp.removeFirst());
        }
        return rEl;
    }
    
    /** Get the top element. */
    public int top() {
        return peekEle;
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