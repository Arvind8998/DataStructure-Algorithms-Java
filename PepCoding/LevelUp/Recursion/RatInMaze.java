package PepCoding.LevelUp.Recursion;
// { Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {

    public static ArrayList<String> getMazePaths(int sr, int sc, int er, int ec, int[][] dir, String[] dirS, String psf,
            int[][] maze) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add(psf);
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        maze[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && maze[r][c] == 1) {
                ArrayList<String> recAns = getMazePaths(r, c, er, ec, dir, dirS, psf + dirS[d], maze);
                for (String s : recAns)
                    ans.add(s);

            }
        }
        maze[sr][sc] = 1;
        return ans;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        if (m[0][0] == 0)
            return new ArrayList<>();
        int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] dirS = { "D", "L", "R", "U" };
        return getMazePaths(0, 0, n - 1, n - 1, dir, dirS, "", m);
    }
}