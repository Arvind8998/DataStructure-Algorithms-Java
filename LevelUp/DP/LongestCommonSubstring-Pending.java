class Solution {
    public int longestCommonSubstr(String S1, String S2, int N, int M, int[][] dp) {
        int maxLen = 0, ei = 0;
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (S1.charAt(n - 1) == S2.charAt(m - 1)) {
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                    if (dp[n][m] > maxLen) {
                        maxLen = dp[n][m];
                        ei = n - 1;
                    }
                }
            }
        }
        return maxLen;
    }

    public int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = longestCommonSubstr(S1, S2, n, m, dp);
        return ans;
    }
}