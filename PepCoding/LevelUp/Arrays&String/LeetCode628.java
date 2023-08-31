class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = (int)1e9;
        int min2 = min1;
        
        int max1 = -(int)1e9;
        int max2 = max1;
        int max3 = max2;
        
        for(int i=0; i< nums.length; i++){
            // max
            if(nums[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1= nums[i];
            }
            else if(nums[i] >= max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] >= max3){
                max3 = nums[i];
            }
            
            //min
            
            if(nums[i] <= min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] <= min2){
                min2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}