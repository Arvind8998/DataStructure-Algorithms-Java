import java.util.Arrays;
class Solution {

    public int getLongestCommonSubsequence(String str1, String str2, int n, int m, int[][] dp){
        if(n == 0 || m==0){
            return dp[n][m] = 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = getLongestCommonSubsequence(str1, str2, n-1, m-1, dp)+1;
        }
        else{
             dp[n][m] = Math.max(getLongestCommonSubsequence(str1, str2, n-1, m, dp), getLongestCommonSubsequence(str1, str2, n, m-1, dp));
        }
        return dp[n][m];    
    }

    public int getLongestCommonSubsequence_DP(String str1, String str2, int N, int M, int[][] dp){
        for(int n =0; n<=N; n++){
            for(int m =0; m<= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                if(str1.charAt(n-1) == str2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1]+1;
                }
                else{
                    dp[n][m] = Math.max( dp[n-1][m], dp[n][m-1]);
                }
            } 
        }
        return dp[N][M];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
            for(int[] d : dp){
                Arrays.fill(d,-1);
            }
        int ans = getLongestCommonSubsequence_DP(text1, text2, n, m, dp);
        return ans;
    }
}