class Solution {
    public int[] twoSum(int[] nums, int target) {
       ArrayList<Integer> ans = new ArrayList<Integer>();
        int si=0, ei = nums.length-1;
        while (si < ei) {
            int sum = nums[si] + nums[ei];
            if (sum == target) {
               ans.add(nums[si++]);
                ans.add(nums[ei--]);
                return ans; 
            }
            else if (sum > target)
                ei--;
            else
                si++;
        }
        
    }
}