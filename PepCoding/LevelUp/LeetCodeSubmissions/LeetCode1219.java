package PepCoding.LevelUp.LeetCodeSubmissions;
class Solution {

    public static int getMazeGold(int sr, int sc, int er, int ec, int[][] dir, int[][] grid) {
        int value = grid[sr][sc], goldAmount = 0;
        grid[sr][sc] = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && grid[r][c] > 0) {
                goldAmount = Math.max(getMazeGold(r, c, er, ec, dir, grid), goldAmount);
            }
        }
        grid[sr][sc] = value;
        return goldAmount + value;
    }

    public int getMaximumGold(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        int n = grid.length, m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int maxGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, getMazeGold(i, j, n - 1, m - 1, dir, grid));
                }

            }
        }
        return maxGold;
    }
}