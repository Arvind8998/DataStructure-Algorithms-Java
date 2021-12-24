import java.util.Arrays;

class Solution {
    long mod = (int) 1e9 + 7;

    public long countFriendsPairings(int n, long[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        long singlePairing = countFriendsPairings(n - 1, dp);
        long doublePairing = n - 2 >= 0 ? countFriendsPairings(n - 2, dp) * (n - 1) : 0;

        return dp[n] = (singlePairing + doublePairing % mod) % mod;
    }

    public long countFriendsPairings(int n) {
        if (n == 0)
            return 0;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairings(n, dp);
    }

}