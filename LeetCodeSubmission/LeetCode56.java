class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int []> st = new LinkedList<int []>();
        
        Arrays.sort(intervals, (a,b)-> {
            return a[0] - b[0];
        });
        
        for(int[] a : intervals){
            int minStartTime = a[0];
            int maxStartTime = a[1];
            while(st.size() != 0 && a[0] <= st.getFirst()[1]){
                minStartTime = st.getFirst()[0];
                maxStartTime = Math.max(st.getFirst()[1], maxStartTime);
                st.removeFirst();
            }
            st.addFirst(new int[]{minStartTime,maxStartTime});
        }
            
           
            int i=0;
            int[][]ans=new int[st.size()][st.size()];
            while(st.size() != 0){
                int[]val=st.removeLast();
                ans[i++] = val;
            }
        return ans;
}
}