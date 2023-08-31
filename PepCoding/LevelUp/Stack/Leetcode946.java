package PepCoding.LevelUp.Stack;
import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
Stack<Integer> st = new Stack<>();
        int idx = 0;
        for(int el :pushed){
            st.push(el);
            while(st.size() >0 && st.peek() == popped[idx]){
                st.pop();
                idx++;
            }
        }
        return idx == popped.length;
    }
}