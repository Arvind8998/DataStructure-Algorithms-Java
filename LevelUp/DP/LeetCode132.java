class Solution {
    public int minCut(String s, int si, int ei, int[] dp, boolean[][] pdp) {
        if (pdp[si][ei])
            return 0;
        if (dp[si] != -1)
            return dp[si];
        int minAns = (int) 1e9;

        for (int cut = si; cut <= ei; cut++) {
            if (pdp[si][cut]) {
                minAns = Math.min(minAns, minCut(s, cut + 1, ei, dp, pdp) + 1);
            }
        }
        return dp[si] = minAns;
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] pdp = new boolean[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    pdp[i][j] = true;
                } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
                    pdp[i][j] = true;
                } else
                    pdp[i][j] = s.charAt(i) == s.charAt(j) && pdp[i + 1][j - 1];
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCut(s, 0, n - 1, dp, pdp);
    }
}