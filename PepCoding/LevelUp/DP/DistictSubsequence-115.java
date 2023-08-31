import java.util.Arrays;

class DistrictsUBequence {
    
    public int numDistinct(int n, int m, String str1, String str2, int[][]dp){
     if(m == 0 || n < m){
         return dp[n][m] = n<m ? 0 : 1;
     }
     if(dp[n][m] != -1){
         return dp[n][m];
     }

     if(str1.charAt(n-1) == str2.charAt(m-1)){
        return dp[n][m] = numDistinct(n-1, m-1, str1, str2, dp) + numDistinct(n-1, m, str1, str2, dp);
     }
     else 
         return dp[n][m] = numDistinct(n-1, m, str1, str2, dp);
         
 }

 public int numDistinct__DP(int N, int M, String str1, String str2, int[][]dp){
     for(int n=0; n<=N; n++){
         for(int m =0; m <=M; m++){
            if(m == 0){
                dp[n][m] = 1;
                continue;
            } 
            if(n < m) {
                dp[n][m] = 0;
                continue;
           }
           if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = dp[n-1][m-1] + dp[n-1][m];
            continue;
           }
           else{
            dp[n][m] = dp[n-1][m];
            continue;
           } 
         }}
         return dp[N][M]; 
         }
     
 public int numDistinct(String s, String t) {
     int n = s.length(), m = t.length();
     int[][] dp = new int[n+1][m+1];
     for(int[] d : dp){
         Arrays.fill(d,-1);
     }
     return numDistinct(n, m, s, t, dp);
 }
}