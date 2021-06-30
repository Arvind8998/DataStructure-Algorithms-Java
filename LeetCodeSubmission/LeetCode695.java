class Solution {
    
    public int dfs(int[][] grid, int sr, int sc, int[][] dir){
        int count =0;
        grid[sr][sc] = 0;

        for(int d=0; d< dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >=0 && c >=0 && r< grid.length && c< grid[0].length && grid[r][c] == 1){
                
            count += dfs(grid, r,c, dir); 
            }
           
        }
        return count +1;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int areaCount = 0, n= grid.length, m =grid[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1)
               areaCount=  Math.max(areaCount, dfs(grid, i, j, dir));
            }
        }
        return areaCount;
        
    }
}