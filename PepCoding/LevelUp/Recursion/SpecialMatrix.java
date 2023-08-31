package PepCoding.LevelUp.Recursion;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {

    public static int getMazePaths(int sr, int sc, int er, int ec, int[][] dir, boolean[][] blockedMat) {
        if (sr == er && sc == ec) {
            return 1;
        }
        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && !blockedMat[r][c])
                count += getMazePaths(r, c, er, ec, dir, blockedMat);

        }
        return count;
    }

    public int FindWays(int n, int m, int[][] blocked_cells) {
        if (blocked_cells[0][0] == 1)
            return 0;
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        boolean[][] mat = new boolean[n][m];

        for (int[] cell : blocked_cells)
            mat[cell[0] - 1][cell[1] - 1] = true;

        return getMazePaths(0, 0, n - 1, m - 1, dir, mat);
    }
}