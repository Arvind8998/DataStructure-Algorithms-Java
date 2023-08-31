package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public int getCombinations(List<List<Integer>> ans, int[] nums, int target){
        if(target == 0){
            return 1;
        }
        
        int count = 0;
        
        for(int i= 0; i<nums.length; i++){
            if(nums[i] > 0 && target - nums[i] >=0){
                count += getCombinations(ans, nums, target-nums[i]);
            }
        }
        
        return count;
    }
    
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        return getCombinations(ans, nums, target);
    }
}