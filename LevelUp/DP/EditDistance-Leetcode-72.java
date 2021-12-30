class Solution {

    public int minDistance(String word1, String word2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = n == 0 ? m : n;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        int insert = minDistance(word1, word2, n, m - 1, dp);
        int delete = minDistance(word1, word2, n - 1, m, dp);
        int replace = minDistance(word1, word2, n - 1, m - 1, dp);

        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return dp[n][m] = replace;
        } else
            return dp[n][m] = Math.min(Math.min(delete, insert), replace) + 1;
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return minDistance(word1, word2, n, m, dp);
    }
}

// public int minDistance_02(String word1, String word2, int n, int m, int[]
// cost, int[][] dp) {
// if (n == 0 || m == 0) {
// return dp[n][m] = (n == 0 ? m * cost[0] : n * cost[2]);
// }

// if (dp[n][m] != -1)
// return dp[n][m];

// int insert = minDistance_02(word1, word2, n, m - 1, cost, dp);
// int delete = minDistance_02(word1, word2, n - 1, m, cost, dp);
// int replace = minDistance_02(word1, word2, n - 1, m - 1, cost, dp);

// if (word1.charAt(n - 1) == word2.charAt(m - 1))
// return dp[n][m] = replace;
// else
// return dp[n][m] = Math.min(Math.min(insert + cost[0], delete + cost[2]),
// replace + cost[1]);
// }

// public int minDistance(String s, String t) {
// int n = s.length(), m = t.length();
// int[][] dp = new int[n + 1][m + 1];
// for (int[] d : dp)
// Arrays.fill(d, -1);

// int ans = minDistance(s, t, n, m, dp);

// return ans;
// }