class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        
        for(int n=0; n<N; n++){
          if(n <= 1){
              dp[n] = cost[n];
              continue;
          }  
            dp[n] = Math.min(dp[n-1], dp[n-2]) + cost[n];
            
        }
        return Math.min( dp[N-1], dp[N-2]);
    }
}