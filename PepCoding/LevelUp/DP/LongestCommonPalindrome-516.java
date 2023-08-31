class Solution {
    public static int longestPalindromeSubseq(int i, int j, String s, int[][] dp) {
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

    public static int longestPalindromeSubseq__DP(int I, int J, String s, int[][] dp) {
        int n = s.length();
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; i++, j++){
                if(i >=j) {
                    dp[i][j] = (i == j ? 1 : 0);
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else 
                    dp[i][j] =  Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[I][J];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return longestPalindromeSubseq__DP(0, n - 1, s, dp);
    }
}