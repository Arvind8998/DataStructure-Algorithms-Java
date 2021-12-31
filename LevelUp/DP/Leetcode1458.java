class Solution {

    public int getMaxNumber(int... nums) {
        int max = nums[0];
        for (int a : nums)
            max = Math.max(a, max);
        return max;
    }

    public int maxDotProduct(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = -(int) 1e8;
        }

        if (dp[n][m] != -(int) 1e9) {
            return dp[n][m];
        }

        int val = nums1[n - 1] * nums2[m - 1];
        int acceptBothNumbers = maxDotProduct(nums1, nums2, n - 1, m - 1, dp) + val;
        int a = maxDotProduct(nums1, nums2, n - 1, m, dp);
        int b = maxDotProduct(nums1, nums2, n, m - 1, dp);

        return dp[n][m] = getMaxNumber(val, acceptBothNumbers, a, b);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -(int) 1e9);
        }
        return maxDotProduct(nums1, nums2, n, m, dp);
    }
}