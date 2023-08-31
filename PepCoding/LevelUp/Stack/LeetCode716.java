package PepCoding.LevelUp.Stack;
import java.io.*;
import java.util.*;

public class Main {
    public static class MaxStack {
        Stack<Integer> data, maxStack;
       
        public MaxStack() {
           data =  new Stack<>();
           maxStack = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            int max = x;
            if (maxStack.size() > 0){
              max = Math.max(maxStack.peek(), max);  
            }
                
            maxStack.push(max);
        }

        public int pop() {
            maxStack.pop();
            return data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int maxtoBeRemoved = maxStack.peek();
            Stack<Integer> buffer = new Stack<>();
            
            
            while (data.peek() != maxtoBeRemoved) {
                int res = pop();
                buffer.push(res);
            }
            pop();

            while (buffer.size() > 0) {
                int res = buffer.pop();
                push(res);
            }
            return maxtoBeRemoved;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        MaxStack maxst = new MaxStack();

        while (read.ready()) {
            String[] inp = read.readLine().split(" ");

            switch (inp[0]) {
                case "pop":
                    System.out.println(maxst.pop());
                    break;
                case "top":
                    System.out.println(maxst.top());
                    break;
                case "popMax":
                    System.out.println(maxst.popMax());
                    break;
                case "peekMax":
                    System.out.println(maxst.peekMax());
                    break;
                case "push":
                    maxst.hashpush(Integer.parseInt(inp[1]));
                    break;
            }

        }

    }
}
