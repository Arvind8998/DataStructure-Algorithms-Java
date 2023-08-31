package PepCoding.LevelUp.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                Queue<Character> queue = new LinkedList<>();
                while (st.peek() != '(') {
                    queue.add(st.pop());
                }
                st.pop();
                while(queue.size() >0){
                    st.push(queue.remove());
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        char[] charArr = new char[st.size()];

        for(int i=charArr.length-1; i>=0; i--){
            charArr[i] = st.pop();
        }
        return new String(charArr);
    }
}