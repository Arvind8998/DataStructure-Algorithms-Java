package PepCoding.LevelUp.DP;
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }
                if (nums1[n - 1] == nums2[m - 1]) {
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                    continue;
                } else {
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
                    continue;
                }

            }
        }
        return dp[N][M];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxUncrossedLines(nums1, nums2, n, m, dp);
    }
}