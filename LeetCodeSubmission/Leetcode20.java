class Solution {
    public boolean isValid(String s) {
          
        LinkedList<Character> st = new LinkedList<>();
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                st.addFirst(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){
                if(st.size() == 0){
                    return false;
                }
                else if(ch == ')' && st.getFirst() != '('){
                    return false;
                }
                else if(ch == '}' && st.getFirst() != '{'){
                    return false;
                }
                else if(ch == ']' && st.getFirst() != '['){
                    return false;
                }
                else
                st.removeFirst();
            }
        }
        return st.size() == 0;
    }
    
}