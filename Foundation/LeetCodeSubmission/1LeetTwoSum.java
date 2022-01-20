import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int si=0, ei = nums.length-1;
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                result[0] = i;
                result[1] = numMap.get(diff);
                return result;
            }
            else{
               numMap.put(nums[i], i); 
            }
            
        }
        return result;
    }
}