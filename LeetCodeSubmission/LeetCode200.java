public void dfs(char[][] grid, int sr, int sc, int[][] dir){
       
    grid[sr][sc] = '0';
    
    for(int d=0; d<4; d++){
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];   
        
        if(r >=0 && c >=0 && r< grid.length && c< grid[0].length && grid[r][c] == '1'){
            dfs(grid, r, c, dir);
        }
    }
}

public int numIslands(char[][] grid) {
    int n = grid.length, m = grid[0].length, islandCount = 0;
    
    int [][] dir = { {1,0}, {-1,0}, {0,-1}, {0,1}, };
    
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            
            if(grid[i][j] == '1'){
              dfs(grid, i, j, dir);
                islandCount++;  
            }
                
        }
    }
    return islandCount;
}