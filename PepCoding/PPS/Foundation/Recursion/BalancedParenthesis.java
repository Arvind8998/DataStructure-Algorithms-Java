import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean handleClosing(Stack<Character> st, char ch) {
        if (st.size() == 0) {
            return false;
        } else if (st.peek() != ch) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        String str = scanner.nextLine();
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                st.push(currentChar);
            } else if (currentChar == ']') {
                boolean val = handleClosing(st, '[');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            } else if (currentChar == ')') {
                boolean val = handleClosing(st, '(');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            } else if (currentChar == '}') {
                boolean val = handleClosing(st, '{');
                if (val == false) {
                    System.out.println(false);
                    return;
                }
            }
        }

        if (st.size() != 0) {
            System.out.println(false);
            return;
        }
        System.out.println(true);

    }

}