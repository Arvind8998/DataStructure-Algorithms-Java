class Solution {
    public int maxChunksToSorted(int[] arr) {
        int leftMax= -(int)1e9;
        int n = arr.length;
        
        int chunks = 0;
        int[] rMin = new int[n+1];
        rMin[n] = (int)1e9;
        
        for(int i=n-1; i>=0; i--){
            rMin[i] = Math.min(rMin[i+1], arr[i]);
        }
        
        for(int i=0; i<n; i++){
           leftMax = Math.max(leftMax, arr[i]);
            
            if(leftMax <= rMin[i+1]){
                chunks++;
            }
        }
        return chunks;
    }
}