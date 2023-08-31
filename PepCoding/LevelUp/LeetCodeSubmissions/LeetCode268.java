package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int idx = 0;
        
        for(int i=0; i<nums.length; i++){
            ans ^= nums[i];
            ans ^= idx;
            idx++;
        }
        ans ^= idx;
        return ans;
    }
}