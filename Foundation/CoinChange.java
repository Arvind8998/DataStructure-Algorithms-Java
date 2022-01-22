class CoinChange {
    public static int getcoinCount(int[] coins, int amount, int idx, int[][] dp) {

        if (amount == 0) {
            return 0;
        }
        if (dp[idx][amount] != 0) {
            return dp[idx][amount];
        }
        int count = Integer.MIN_VALUE;

        for (int i = idx; i >= 0; i--) {
            if (amount - coins[i] >= 0) {
                count = Math.max(count, getcoinCount(coins, amount - coins[i], i, dp));
            }
        }
        return dp[idx][amount] = count == Integer.MAX_VALUE ? count : count + 1;
    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length - 1;
        int[][] dp = new int[coins.length + 1][amount + 1];
        int ret = getcoinCount(coins, amount, len, dp);
        return ret == Integer.MIN_VALUE ? -1 : ret;

    }

    public static void main(String[] args) {
        int[] coins = { 3, 5, 10 };
        System.out.println(coinChange(coins, 15));
    }
}