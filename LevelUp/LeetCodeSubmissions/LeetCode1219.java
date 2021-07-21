class Solution {

    public static int getMazeGold(int sr, int sc, int er, int ec, int[][] dir, int[][] maze) {
        if (sr == er && sc == ec) {
            return maze[sr][sc];
        }

        int goldAmount = 0;
        maze[sr][sc] = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && maze[r][c] == 0) {
                goldAmount = Math.max(getMazeGold(r, c, er, ec, dir, maze), goldAmount);
            }
        }
        maze[sr][sc] = 1;
        return goldAmount;
    }

    public int getMaximumGold(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        return getMazeGold(0, 0, grid.length - 1, grid[0].length - 1, dir, grid);
    }
}