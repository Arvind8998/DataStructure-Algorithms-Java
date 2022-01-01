import java.util.Arrays;
import java.util.Scanner;

public class GoldMine {

    public static int goldMine(int sr, int sc, int[][] dir, int[][] arr, int[][] dp) {
        int n = arr.length, m = arr[0].length;
        if (sc == m - 1) {
            return dp[sr][sc] = arr[sr][sc];
        }

        if (dp[sr][sc] != -1)
            return dp[sr][sc];
        int maxGold = 0;

        for (int[] d : dir) {
            int r = sr + d[0];
            int c = sc + d[1];
            if (r >= 0 && c >= 0 && r < n && c < m)
                maxGold = Math.max(maxGold, goldMine(r, c, dir, arr, dp) + arr[sr][sc]);
        }
        return dp[sr][sc] = maxGold;
    }

    public static int getGold() {
        int[][] arr = { { 1, 3, 1, 5 },
                { 2, 2, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 } };

        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int n = arr.length, m = arr[0].length;

        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        int maxGold = 0;
        int rIdx = 0;
        for (int r = 0; r < n; r++) {
            int ans = goldMine(r, 0, dir, arr, dp);
            if (ans > maxGold) {
                maxGold = ans;
                rIdx = r;
            }
        }
        goldMine_backEngg(dp, dir, rIdx, 0, "");
        return maxGold;
    }

    public static void goldMine_backEngg(int[][] dp, int[][] dir, int sr, int sc, String asf) {
        if (sc == dp[0].length - 1) {
            System.out.println(asf + "( " + sr + ", " + sc + ") ");
            return;
        }
        int maxGold = 0;
        int idx = -1;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && dp[r][c] > maxGold) {
                maxGold = dp[r][c];
                idx = d;
            }
        }

        if (idx != -1) {
            int r = sr + dir[idx][0];
            int c = sc + dir[idx][1];
            goldMine_backEngg(dp, dir, r, c, asf + "( " + sr + ", " + sc + ") ");
        }

    }

    public static void main(String[] args) {
        System.out.println("Max gOLD IS" + " " + getGold());
    }
}
