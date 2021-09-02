class Solution {
    public int mazePath(int sr, int sc, int er, int ec, int[][]dp, int[][] dir){
        if(sr == er && sc == ec){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }

        int count = 0;

        for(int d=0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >=0 && c >=0 && r <= er && c <= ec ){
                count += mazePath(r, c, er, ec, dp, dir);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int uniquePaths(int m, int n) {
        int sr = 0, sc =0, er =m, ec= n;
        int[][] dir = { {0,1}, {1,0}};

        int[][] dp = new int[er+1][ec+1];
        return mazePath(sr, sc, er-1, ec-1, dp, dir);
    }
}