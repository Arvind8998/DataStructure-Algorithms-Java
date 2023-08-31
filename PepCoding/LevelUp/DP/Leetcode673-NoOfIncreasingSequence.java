class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] dp = new int[n];
        int maxCount = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxCount = count[i];
            } else if (dp[i] == maxLength) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}