package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int[][] dir= { {1,0}, {0,1}};
        
        return mazePath__tabul(0,0, m-1, n-1, dp, dir);
    }
    
    public static int mazePath__tabul(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir){
        for(int sr=ER; sr>= SR; sr--){
            for(int sc = EC; sc >= SC; sc--){
                if(ER == sr && EC == sc ){
                    dp[sr][sc] = 1;
                    continue;
                }
        int count = 0;

        for(int[]d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if(r >=0 && c >=0 && r < dp.length && c < dp[0].length ){
                count += dp[r][c];
            }
        }
            
        dp[sr][sc] = count;
    }
    }
        return dp[SR][SC];
    }
}