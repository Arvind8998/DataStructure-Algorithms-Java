class MyQueue {

    /** Initialize your data structure here. */
    LinkedList<Integer> st = new LinkedList<Integer> ();
    LinkedList<Integer> temp = new LinkedList<Integer> ();
    int peekEle; 
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        transfer(st,temp);
        st.addFirst(x);
        transfer(temp,st);
        
    }
    
    public void transfer(LinkedList <Integer> st1, LinkedList <Integer> st2){
        while(st1.size() != 0){
            st2.addFirst(st1.removeFirst());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.removeFirst();
    }
    
    /** Get the front element. */
    public int peek() {
        return st.getFirst();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */