class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean isOnePresent = false;
        
        // mark out of bound elements as true
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                isOnePresent = true;
            } 
            
            if( nums[i] < 1 || nums[i] > n){
                nums[i] = 1;
            }
        }
        
        if(isOnePresent == false){
            return 1;
        }
        
        // traverse and mark idx as -ve
        for(int i=0; i<n; i++){
            int idx = Math.abs(nums[i]);
            nums[idx-1] = -Math.abs(nums[idx-1]);
        }
        
        //first postive element with idx+1 is answer
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        
        return n+1;
        
        
    }
}