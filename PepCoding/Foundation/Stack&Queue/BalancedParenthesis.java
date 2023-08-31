import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static boolean balancedBracket(String str){
        LinkedList<Character> st = new LinkedList<>();
        for(int i = 0; i< str.length(); i++){
            char ch = str.charAt(i);
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

    public static void main(String[] args) throws Exception {
        String str = scn.nextLine();
        System.out.println(balancedBracket(str));
    }

}