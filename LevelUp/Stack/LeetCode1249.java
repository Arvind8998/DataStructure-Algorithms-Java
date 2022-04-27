import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(st.size() == 0){
                    charArr[i] = '.';
                }
                else{
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while(st.size() >0){
            charArr[st.pop()] = '.';
        }

        for(char ch: charArr){
            if(ch != '.'){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}