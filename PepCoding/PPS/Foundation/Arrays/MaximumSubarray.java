class Solution {
    public int maxSubArray(int[] nums) {

        int csum = nums[0], overallSum = nums[0], n = nums.length;

        for (int i = 1; i < n; i++) {
            if (csum + nums[i] > nums[i]) {
                csum += nums[i];
            } else {
                csum = nums[i];
            }

            if (csum > overallSum) {
                overallSum = csum;
            }

        }
        return overallSum;

    }
}