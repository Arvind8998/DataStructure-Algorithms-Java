package PepCoding.LevelUp.DP;
class Solution {

    public int lengthOfLIS(int[] nums, int[] dp) {
        int n = nums.length, maxLength = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return lengthOfLIS(nums, dp);
    }

    // public static int LIS_memo(int[] arr, int ei, int[] dp) {
    // if (dp[ei] != 0)
    // return dp[ei];
    // int maxLen = 1;
    // for (int i = ei - 1; i >= 0; i--) {
    // if (arr[i] < arr[ei]) {
    // int recLen = LIS_memo(arr, i, dp);
    // maxLen = Math.max(maxLen, recLen + 1);
    // }
    // }

    // return dp[ei] = maxLen;
    // }

    // public static int LIS_Rec() {
    // int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 14 };
    // int[] dp = new int[arr.length];
    // int maxLen = 0;
    // for (int i = 0; i < arr.length; i++) {
    // maxLen = Math.max(maxLen, LIS_memo(arr, i, dp));
    // }

    // return maxLen;
    // }
}