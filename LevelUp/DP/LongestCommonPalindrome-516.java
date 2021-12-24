class Solution {
    public int longestPalindromeSubseq(int i, int j, String s, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = (i != j ? 0 : 1);
        }
        if (dp[i][j] != 0)
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = Math.max(longestPalindromeSubseq(i + 1, j, s, dp),
                    longestPalindromeSubseq(i, j - 1, s, dp));
        } else
            return dp[i][j] = longestPalindromeSubseq(i + 1, j - 1, s, dp) + 2;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return longestPalindromeSubseq(0, n - 1, s, dp);
    }
}