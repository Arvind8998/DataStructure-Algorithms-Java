package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public int getcoinCount(int[] coins, int amount, int idx,int[][] dp){
        
        if(amount == 0){
            return 0;
        }
        if(dp[idx][amount]!=0){
            return dp[idx][amount];
        }
        int count = Integer.MAX_VALUE;
        
        for(int i=idx; i>=0; i--){
            if(amount-coins[i] >=0){
                count = Math.min(count, getcoinCount(coins, amount-coins[i], i,dp));
            }
        }
            return dp[idx][amount] = count==Integer.MAX_VALUE ?count :count+1;
    }
    
    public int coinChange(int[] coins, int amount) {
        int len = coins.length-1;
        int[][] dp = new int[coins.length+1][amount+1];
        int ret = getcoinCount(coins, amount, len,dp);
        return ret== Integer.MAX_VALUE ?-1: ret;
       
    }
}



// The population of New York City is estimated to be over 10 million people, divided into three income groups: high, average, and low. If a cab driver's average journey time is 20 minutes and he works for 12 hours each day, he will make 40 trips per day.
// The number of taxi drivers in NYC every day is equal to the number of automobiles when the total number of trips in NYC is divided by the number of journeys that each driver makes.

