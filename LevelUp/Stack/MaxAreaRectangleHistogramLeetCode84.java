import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=0 ; i<= heights.length; i++){
            int val = i== heights.length ? 0 : heights[i];
            while( st.peek() != -1 && heights[st.peek()] >= val){
                int rmin = i;
                int height = heights[st.pop()];
                int lmin = st.peek();
                int width = rmin-lmin-1;
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}