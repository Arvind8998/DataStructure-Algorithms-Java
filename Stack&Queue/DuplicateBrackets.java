import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    
    public static boolean duplicateBrackets(String str){
        LinkedList<Character> st = new LinkedList<Character>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            boolean isLoopRun = false;
            while(st.size() != 0 && ch == ')' && st.getFirst() != '('){
                st.removeFirst();
                isLoopRun = true;
            }
            if(!isLoopRun && ch == ')'){
                return true;
            }
            else if(isLoopRun ){
                st.removeFirst();
            }
            else{
                st.addFirst(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
    String str = scn.nextLine();
    System.out.println(duplicateBrackets(str));
    }

}