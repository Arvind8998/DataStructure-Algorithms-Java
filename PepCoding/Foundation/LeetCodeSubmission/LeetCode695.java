class Solution {
    public int dfs(int i, int j, int[][] grid, int[][] dir) {
        for (int d = 0; d < dir.length; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            int count = 0;
            if (r >= 0 && r < grid.length && c >= 0 && j < grid[0].length &&
                    grid[r][c] == 1) {
                count += dfs(r, c, grid, dir);
            }
        }
        return count + 1;

    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int maxArea = -(int) 1e9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid, dir));
                }
            }
        }
        return maxArea;
    }
}