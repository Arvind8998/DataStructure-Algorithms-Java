import java.io.*;
import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dir = {  { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 },  };
        String[] dirS = { "t", "l", "d", "r" };
        System.out.println(floodfill(arr, 0, 0, n - 1, m - 1, "", dir, dirS));
    }
    
    
  public static int floodfill(int[][] maze, int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        maze[sr][sc] = 1;
        int count = 0;

        for (int d = 0; d < dirS.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && maze[r][c] == 0) {
                count += floodfill(maze, r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }
        maze[sr][sc] = 0;
        return count;
    }
}
