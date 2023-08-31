class Solution {
    public int getPotentialMajorEl(int[] nums) {
        int count = 1, value = nums[0];
        for (int num : nums) {
            if (num == value) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                value = num;
                count = 1;
            }
        }
        return value;
    }

    public int majorityElement(int[] nums) {

        int potentialMajorEl = getPotentialMajorEl(nums), count = 0;
        for (int el : nums) {
            if (el == potentialMajorEl) {
                count++;
            }
        }
        return count > nums.length/2 ? potentialMajorEl : -1;

    }
}